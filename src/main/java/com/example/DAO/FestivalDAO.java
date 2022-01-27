package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.other.Festival;
import com.example.other.Tools;

public class FestivalDAO extends DAO<Festival> {

    public FestivalDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Festival obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Festival(nom,region,domaine,complement_domaine,periodicite,moisdebut,siteIngternet,ville,codePostal,Coordonnees,departement,commentaire,duree,capacite)"+
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
					);
			
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getLocalisation().getRegion());
			prepare.setString(3, obj.getDomaine());
			prepare.setString(4,obj.getComplementDomaine());
			prepare.setString(5, obj.getPeriodicite());
			
			prepare.setString(6,obj.getMoisDebut());
			prepare.setString(7,obj.getSiteInternet());
			prepare.setString(8,obj.getLocalisation().getCommune());
			prepare.setInt(9,obj.getLocalisation().getCodePostal());
			prepare.setString(10, obj.getLocalisation().getCoordonnesGPSString());
			prepare.setString(11,obj.getLocalisation().getDepartement());
			prepare.setString(12,obj.getCommentaire());
			prepare.setInt(13,obj.getDuree());
			prepare.setInt(14,obj.getCapacite());

			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override	
	public Festival read(int id) {	
			Statement myStm;
			 
			Festival festival = null;
			
			try {
				String q = 	"SELECT * FROM Festival " +
						"WHERE IDFestival="+id;
				myStm = this.connect.createStatement(this.type,this.mode);
				
				ResultSet rs = myStm.executeQuery(q);
				while(rs.next()) {
					festival = Tools.readFestival(rs);
				}
				
			}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
			return festival;
	}

	@Override
	public boolean update(Festival obj) {
		
		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update FESTIVAL set siteInternet,Commentaire"+
					"where IDEtab="+obj.getIdFestival() );
			
			prepare.setString(1, obj.getSiteInternet());
			
			prepare.setString(3, obj.getCommentaire());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Festival obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFesti = "delete from Festival where IDFestival="+obj.getIdFestival();
			del = myStm.executeUpdate(supFesti);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}
	
	public ArrayList<Festival> listFestivalReachByVille(String ville) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE VILLE = '"+ville+"'";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(Tools.readFestival(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}
	
	public ArrayList<Festival> listFestivalReachByDepartement(String departement) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE DEPARTEMENT = '"+departement+"'";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(Tools.readFestival(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}
	
	
	public ArrayList<Festival> listFestivalReachByType(String Domaine) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE Domaine = '"+Domaine+"'";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(Tools.readFestival(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}
}
