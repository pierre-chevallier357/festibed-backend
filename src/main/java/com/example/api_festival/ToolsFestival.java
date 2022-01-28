package com.example.api_festival;

import java.sql.ResultSet;
import java.sql.SQLException;



public abstract class ToolsFestival {


	public static Festival readFestivalInformation(ResultSet rs){
		Festival festival = new Festival();
		try{
			festival.setNom(rs.getString("Nom"));
			festival.setDomaine(rs.getString("Domaine"));
			try{
				festival.setComplementDomaine(rs.getString("Complement_Domaine"));
			}catch(SQLException e){
				festival.setComplementDomaine("");
			}
			festival.setMoisIndicatif(rs.getString("MoisIndicatif"));
			festival.setDuree(rs.getInt("Duree"));
			festival.setIdFestival(rs.getInt("IDFestival"));
			try{
				festival.setCommune(rs.getString("ville"));
			}catch(SQLException e){
				festival.setCommune("Ville inconnue");
			}
			try{
				festival.setDepartement(rs.getString("departement"));
			}catch(SQLException e){
				festival.setDepartement("Departement inconnu");
			}
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
			
			try{
				festival.setCodePostal(rs.getInt("codePostal"));
			}catch(SQLException e){
				festival.setCodePostal(-1);
			}
			try{
				festival.setCommune(rs.getString("ville"));
			}catch(SQLException e){
				festival.setCommune("Ville inconnue");
			}
			try{
				festival.setCoordonnesGPS(rs.getString("coordonnees"));
			}catch(SQLException e){
				festival.setCoordonnesGPS("Coordonnee inconnue");
			}			
			try{
				festival.setDepartement(rs.getString("departement"));
			}catch(SQLException e){
				festival.setDepartement("Departement inconnu");
			}
			
			try{
				festival.setRegion(rs.getString("region"));
			}catch(SQLException e){
				festival.setRegion("region inconnue");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return festival;
	}
}
