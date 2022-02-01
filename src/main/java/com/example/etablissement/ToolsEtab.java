package com.example.etablissement;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class ToolsEtab {

    public static Etablissement getAllInfo(ResultSet rs) {
		Etablissement etablissement = new Etablissement();
		try {
			etablissement.setType(rs.getString("type"));
			etablissement.setNom(rs.getString("nomEtab"));
			etablissement.setCapaciteDAccueil(rs.getInt("capacite"));
			etablissement.setClassement(rs.getString("classement"));
			etablissement.setIDEtab(rs.getInt("iDEtablissement"));
			etablissement.setSiteInternet(rs.getString("siteInternet"));
			etablissement.setEmail(rs.getString("courriel"));
			etablissement.setTelephone(rs.getString("telephone"));
			etablissement.setNbLogement(rs.getInt("NBLOGEMENT"));
			
			etablissement.setAdresse(rs.getString("adresse"));
			etablissement.setCodePostal(rs.getInt("codePostal"));
			etablissement.setCoordonnesGPS(rs.getString("coordonnees"));
			etablissement.setCommune(rs.getString("ville"));
			etablissement.setDepartement(rs.getString("departement"));
			etablissement.setRegion(rs.getString("region"));
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return etablissement;

	}


	public static Etablissement readEtablissementByType(ResultSet rs, String type) {
		
		Etablissement etablissement = null;
		switch (type){
			case "HOTEL" : 
					etablissement = new Hotel();
			break;
			case "CAMPING" :
				etablissement = new Camping();	
			break;
			case "PARC RESIDENTIEL DE LOISIRS" :
				etablissement = new Parc();
				break;
			case "VILLAGE DE VACANCES" :
				etablissement = new Village();
				break;
			case "RESIDENCE DE TOURISME" :
				etablissement = new Residence();
			break;
		}
		etablissement = getAllInfo(rs);
		return etablissement;
	}
    
}
