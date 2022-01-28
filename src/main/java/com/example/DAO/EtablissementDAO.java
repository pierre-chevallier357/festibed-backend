package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.api_festival.ToolsFestival;
import com.example.etablissement.*;

public class EtablissementDAO extends DAO<Etablissement> {

    public EtablissementDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Etablissement obj) {
		
		boolean res = true; 

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Etablissement(type,classement,nomEtab,adresse,codePostal,ville,telephone,siteInternet,capacite,nbLogement,coordonnee,departement,region)"+
					"values(?,?,?,?,?,?,?,?,?,?,?,?)"
					);
			
			prepare.setString(1, obj.getType());
			prepare.setString(2, obj.getClassement());
			prepare.setString(3, obj.getNomCommercial());
			prepare.setString(4,obj.getLocalisation().getAdresse());
			prepare.setInt(5, obj.getLocalisation().getCodePostal());
			prepare.setString(6,obj.getLocalisation().getCommune());
			prepare.setString(7,obj.getNumeroDeTelephone());
			prepare.setString(8,obj.getSiteInternet());
			prepare.setInt(9,obj.getCapaciteDAccueil());
			prepare.setInt(10, obj.getNbLogement());
			prepare.setString(10,obj.getLocalisation().getCoordonnesGPSString());
			prepare.setString(11,obj.getLocalisation().getDepartement());
			prepare.setString(12,obj.getLocalisation().getRegion());

			prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	@Override	
	public Etablissement read(int id) {	
			Statement myStm;
			 
			Etablissement etablissement = null;
			
			try {
				String q = 	"SELECT * FROM ETABLISSEMENT " +
						"WHERE IDEtablissement="+id;
				myStm = this.connect.createStatement(this.type,this.mode);
				
				ResultSet rs = myStm.executeQuery(q);
				while(rs.next()) {
					String type = rs.getString("type");
					etablissement = ToolsFestival.readEtablissementByType(rs, type);
				}
				
			}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
			return etablissement;
	}

	@Override
	public boolean update(Etablissement obj) {
		
		boolean res = true;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update ETABLISSEMENT set telephone,siteInternet,capacite,nbLogement"+
					"where IDEtab="+obj.getIDEtab() );
			
			prepare.setString(1, obj.getNumeroDeTelephone());
			prepare.setString(2, obj.getSiteInternet());
			prepare.setInt(3, obj.getCapaciteDAccueil());
			prepare.setInt(4, obj.getNbLogement());
				    		
			prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}

	@Override
	public boolean delete(Etablissement obj) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supEtab = "delete from Etablissement where IDEtablissement="+obj.getIDEtab();
			myStm.executeUpdate(supEtab);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
	
	public ArrayList<Etablissement> listEtab(int idFestival, String type) {	
		ArrayList<Etablissement> etabList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM ETABLISSEMENT WHERE TYPE = '"+type+"'";//+"' and idFestival="+idFestival;
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				
				etabList.add(ToolsFestival.readEtablissementByType(rs, type));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etabList;
	
	}

	public int getIdEtablissement(String email) {
		
		int idEtablissement = -1;
		Statement myStm;
		
		try {
			myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT IDEtablissement FROM Etablissement " +
					"WHERE email= '"+email+"'";
		
			ResultSet rs = myStm.executeQuery(q);
			if(rs.first()) {
				idEtablissement = rs.getInt("idEtablissement");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idEtablissement;
	}

}
