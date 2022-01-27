package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.etablissement.Village;

import com.example.etablissement.Camping;
import com.example.etablissement.Etablissement;
import com.example.etablissement.Hotel;
import com.example.etablissement.Parc;
import com.example.etablissement.Residence;

public abstract class Tools {

	
	
	public static Etablissement readEtablissementByType(ResultSet rs, String type) {
		
		Etablissement etablissement = null;
		Localisation localisation = new Localisation();
		
		try {
			switch (type){
		
				case "H�TEL" : 
		
					
					
						etablissement = new Hotel();
						etablissement.setNomCommercial(rs.getString("nomEtab"));
						etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
						etablissement.setClassement(rs.getString("classement"));
						etablissement.setIDEtab(rs.getInt("IDETABLISSEMENT"));
						etablissement.setSiteInternet(rs.getString("SITEINTERNET"));
						etablissement.setEmail(rs.getString("COURRIEL"));
						etablissement.setNumeroDeTelephone(rs.getString("telephone"));
						etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
						
						localisation.setAdresse(rs.getString("adresse"));
						localisation.setCodePostal(rs.getInt("codePostal"));
						localisation.setCommune(rs.getString("ville"));
						localisation.setCoordonnesGPS(rs.getString("coordonnees"));
						localisation.setDepartement(rs.getString("departement"));
						localisation.setRegion(rs.getString("region"));
						
						etablissement.setLocalisation(localisation);
					
				break;
				
				case "CAMPING" :
		
					etablissement = new Camping();
					
		
						etablissement.setNomCommercial(rs.getString("nomEtab"));
						etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
						etablissement.setClassement(rs.getString("classement"));
						etablissement.setIDEtab(rs.getInt("iDEtablissement"));
						etablissement.setSiteInternet(rs.getString("siteInternet"));
						etablissement.setEmail(rs.getString("email"));
						etablissement.setNumeroDeTelephone(rs.getString("telephone"));
						etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
						
						localisation.setAdresse(rs.getString("adresse"));
						localisation.setCodePostal(rs.getInt("codePostal"));
						localisation.setCommune(rs.getString("ville"));
						localisation.setCoordonnesGPS(rs.getString("coordonnees"));
						localisation.setDepartement(rs.getString("departement"));
						localisation.setRegion(rs.getString("region"));
						
						etablissement.setLocalisation(localisation);
					
				break;
		
				case "PARC RESIDENTIEL DE LOISIRS" :
		
					etablissement = new Parc();
					
		
						etablissement.setNomCommercial(rs.getString("nomEtab"));
						etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
						etablissement.setClassement(rs.getString("classement"));
						etablissement.setIDEtab(rs.getInt("iDEtablissement"));
						etablissement.setSiteInternet(rs.getString("siteInternet"));
						etablissement.setEmail(rs.getString("email"));
						etablissement.setNumeroDeTelephone(rs.getString("telephone"));
						etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
						
						localisation.setAdresse(rs.getString("adresse"));
						localisation.setCodePostal(rs.getInt("codePostal"));
						localisation.setCommune(rs.getString("ville"));
						localisation.setCoordonnesGPS(rs.getString("coordonnees"));
						localisation.setDepartement(rs.getString("departement"));
						localisation.setRegion(rs.getString("region"));
						
						etablissement.setLocalisation(localisation);
						
					
				break;
		
				
				case "VILLAGE DE VACANCES" :
		
					etablissement = new Village();
					
		
						etablissement.setNomCommercial(rs.getString("nomEtab"));
						etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
						etablissement.setClassement(rs.getString("classement"));
						etablissement.setIDEtab(rs.getInt("iDEtablissement"));
						etablissement.setSiteInternet(rs.getString("siteInternet"));
						etablissement.setEmail(rs.getString("email"));
						etablissement.setNumeroDeTelephone(rs.getString("telephone"));
						etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
						
						localisation.setAdresse(rs.getString("adresse"));
						localisation.setCodePostal(rs.getInt("codePostal"));
						localisation.setCommune(rs.getString("ville"));
						localisation.setCoordonnesGPS(rs.getString("coordonnees"));
						localisation.setDepartement(rs.getString("departement"));
						localisation.setRegion(rs.getString("region"));
						
						etablissement.setLocalisation(localisation);
					
					break;
		
				
				case "RESIDENCE DE TOURISME" :
		
					etablissement = new Residence();
					
						
						etablissement.setNomCommercial(rs.getString("nomEtab"));
						etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
						etablissement.setClassement(rs.getString("classement"));
						etablissement.setIDEtab(rs.getInt("iDEtablissement"));
						etablissement.setSiteInternet(rs.getString("siteInternet"));
						etablissement.setEmail(rs.getString("email"));
						etablissement.setNumeroDeTelephone(rs.getString("telephone"));
						etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
						
						localisation.setAdresse(rs.getString("adresse"));
						localisation.setCodePostal(rs.getInt("codePostal"));
						localisation.setCommune(rs.getString("ville"));
						localisation.setCoordonnesGPS(rs.getString("coordonnees"));
						localisation.setDepartement(rs.getString("departement"));
						localisation.setRegion(rs.getString("region"));
						
						etablissement.setLocalisation(localisation);
					
				break;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return etablissement;
	}

	
	public static Festival readFestival(ResultSet rs) {
		
		Festival festival = new Festival();
		Localisation localisation = new Localisation();
		
		try {
			festival.setNom(rs.getString("Nom"));
			festival.setDomaine(rs.getString("Domaine"));
			festival.setComplementDomaine(rs.getString("Complement_Domaine"));
			festival.setMoisIndicatif(rs.getString("MoisIndicatif"));
			festival.setDuree(rs.getInt("Duree"));
			festival.setIdFestival(rs.getInt("IDFestival"));
			
			localisation.setCodePostal(rs.getInt("codePostal"));
			localisation.setCommune(rs.getString("ville"));
			localisation.setCoordonnesGPS(rs.getString("coordonnees"));
			localisation.setDepartement(rs.getString("departement"));
			localisation.setRegion(rs.getString("region"));
			
			festival.setLocalisation(localisation);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return festival;
	}
}
