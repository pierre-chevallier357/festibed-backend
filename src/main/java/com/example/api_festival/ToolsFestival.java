package com.example.api_festival;

import java.sql.ResultSet;
import java.sql.SQLException;



public abstract class ToolsFestival {


	public static Festival readFestivalInformation(ResultSet rs){
		Festival festival = new Festival();
		try{
			festival.setNom(rs.getString("Nom"));
			festival.setDomaine(rs.getString("Domaine"));
			festival.setComplementDomaine(rs.getString("Complement_Domaine"));
			festival.setMoisIndicatif(rs.getString("MoisIndicatif"));
			festival.setDuree(rs.getInt("Duree"));
			festival.setIdFestival(rs.getInt("IDFestival"));
			festival.setCommune(rs.getString("ville"));
			festival.setDepartement(rs.getString("departement"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return festival;
	}
	public static Festival readFestival(ResultSet rs) {
		
		Festival festival = new Festival();
		
		try {
			festival.setNom(rs.getString("Nom"));
			festival.setDomaine(rs.getString("Domaine"));
			festival.setComplementDomaine(rs.getString("Complement_Domaine"));
			festival.setMoisIndicatif(rs.getString("MoisIndicatif"));
			festival.setDuree(rs.getInt("Duree"));
			festival.setIdFestival(rs.getInt("IDFestival"));
			festival.setCodePostal(rs.getInt("codePostal"));
			festival.setCommune(rs.getString("ville"));
			festival.setCoordonnesGPS(rs.getString("coordonnees"));
			festival.setDepartement(rs.getString("departement"));
			festival.setRegion(rs.getString("region"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return festival;
	}
}
