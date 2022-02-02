package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.api_festival.Festival;
import com.example.api_festival.ToolsFestival;

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
			prepare.setString(2, obj.getRegion());
			prepare.setString(3, obj.getDomaine());
			prepare.setString(4,obj.getComplementDomaine());
			prepare.setString(5, obj.getPeriodicite());
			
			prepare.setString(6,obj.getMoisDebut());
			prepare.setString(7,obj.getSiteInternet());
			prepare.setString(8,obj.getCommune());
			prepare.setInt(9,obj.getCodePostal());
			prepare.setString(10, obj.getCoordonnesGPSString());
			prepare.setString(11,obj.getDepartement());
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
					int i = rs.getInt("Capacite");
					int j = rs.getInt("NBPlacesReservees");
					if(i != 0 && j  != 0){
						
					System.out.println("capacite :"+i+" NbplaceReserver :"+j );
						if(j>=i){
							rs.next();
						}
						else {
							festival = ToolsFestival.readFestival(rs);
						}
					}else {
						festival = ToolsFestival.readFestival(rs);
					}
					
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
	
	public ArrayList<Festival> searchFestivalsByVille(String ville) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE VILLE LIKE '%"+ville+"%'";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(ToolsFestival.readFestivalInformation(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}
	
	public ArrayList<Festival> searchFestivalsByDepartement(String departement) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE DEPARTEMENT = '"+departement+"'";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(ToolsFestival.readFestivalInformation(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}

	public Festival readIdByName(Festival festival) {	
		Statement myStm;
		
		try {
			String q = 	"SELECT IdFestival FROM Festival " +
					"WHERE NOM= '"+festival.getNom()+"'";
			myStm = this.connect.createStatement(this.type,this.mode);
			
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festival.setIdFestival(rs.getInt("idFestival"));
			}
			
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		return festival;
	}

	public ArrayList<Festival> searchHundredFestivals() {		
		ArrayList<Festival> festivalList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE idFestival < 101";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				festivalList.add(ToolsFestival.readFestivalInformation(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	}


	public ArrayList<Festival> searchFestivals(String nom, String ville, String type, String departement, String mois) {	
		ArrayList<Festival> festivalList = new ArrayList<>();
		boolean isFirst = true;
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festival WHERE";

			if(!nom.equals("null")){
				if(isFirst){
					q += " UPPER(NOM) LIKE '%"+nom+"%'";
					isFirst = false;
				}
			}
			if(!ville.equals("null")){
				if(isFirst){
					isFirst = false;

				}
				else{
					q+= " AND ";
				}
				q += " UPPER(VILLE) LIKE '%"+ville+"%'";
			}
			if(!type.equals("null")){
				if(isFirst){
					isFirst = false;

				}
				else{
					q+= " AND ";
				}
				q += " DOMAINE = '"+type+"'";
			}

			if(!departement.equals("null")){
				if(isFirst){
					isFirst = false;

				}
				else{
					q+= " AND ";
				}
				q += " departement LIKE '%"+departement+"%'";
			}
			if(!mois.equals("null")){
				if(isFirst){
					isFirst = false;

				}
				else{
					q+= " AND ";
				}
				q += " moisDebut LIKE '%"+mois+"%'";
			}
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				int i = rs.getInt("Capacite");
				int j = rs.getInt("NBPlacesReservees");
				if(i != 0 && j  != 0){
					System.out.println("capacite :"+i+" NbplaceReserver :"+j );
					if(j>=i){
						rs.next();
					}
					else {
						festivalList.add(ToolsFestival.readFestivalInformation(rs));
					}
				}else {
					festivalList.add(ToolsFestival.readFestivalInformation(rs));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festivalList;
	
	}
}
