package com.example.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.utilisateur.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur> {

    public OrganisateurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Organisateur obj) {
		
		boolean res = false;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Organisateur(nom,email)"+
					"values(?,?)"
					);
			
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getEmail());

			prepare.executeUpdate();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
		
	public Organisateur read(int id) {
		
		Organisateur organisateur = new Organisateur();		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Organisateur " +
						"WHERE IDOrganisateur="+id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				organisateur.setEmail(rs.getString("email"));
				organisateur.setNom(rs.getString("nom"));
				organisateur.setIdUser(rs.getInt("idOrganisateur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return organisateur;
	}

	@Override
	public boolean update(Organisateur obj) {
		
		boolean res = true; 
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update Organisateur set nom=?, email=?"+
					"where IDOrganisateur="+obj.getIdUser() );
			
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getEmail());

				    		
			prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}

	@Override
	public boolean delete(Organisateur obj) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from Organisateur where IDOrganisateur="+obj.getIdUser();
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
	
	public int getIdOrganisateur(String email) {
		
		int idOrganisateur = -1;
		Statement myStm;
		
		try {
			myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT IDOrganisateur FROM Organisateur " +
					"WHERE email= '"+email+"'";
		
			ResultSet rs = myStm.executeQuery(q);
			if(rs.first()) {
				idOrganisateur = rs.getInt("idOrganisateur");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idOrganisateur;
	}
	
	public ArrayList<Organisateur> listOrganisateur(){
		ArrayList<Organisateur> HebergList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Organisateur";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				Organisateur Organisateur = new Organisateur();
				Organisateur.setEmail(rs.getString("email"));
				Organisateur.setNom(rs.getString("nom"));
				Organisateur.setIdUser(rs.getInt("idOrganisateur"));
				
				HebergList.add(Organisateur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HebergList;
	
	}

	public Integer find(String email, String password) {
			
		Integer id = null;

		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT idOrganisateur FROM Organisateur " +
						"WHERE email= '"+email+"' and password= '"+password+"'";
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				id = rs.getInt("idOrganisateur");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
    
}
