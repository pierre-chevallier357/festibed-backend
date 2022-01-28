package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.etablissement.Hotel;

public class HotelDAO extends DAO<Hotel> {

    public HotelDAO(Connection conn) {
        super(conn);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean create(Hotel obj) {
		
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
    public Hotel read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Hotel user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Hotel obj) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
