package com.example.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.utilisateur.Hebergeur;


public class HebergeurDAO extends DAO<Hebergeur> {
    
    public HebergeurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Hebergeur obj) {
		
		boolean res = false;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Hebergeur(nom,email)"+
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
		
	public Hebergeur read(int id) {
		
		Hebergeur hebergeur = new Hebergeur();		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Hebergeur " +
						"WHERE IDHebergeur="+id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				hebergeur.setEmail(rs.getString("email"));
				hebergeur.setNom(rs.getString("nom"));
				hebergeur.setIdUser(rs.getInt("idHebergeur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hebergeur;
	}

	@Override
	public boolean update(Hebergeur obj) {
		
		boolean res = true; 
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update Hebergeur set nom=?, email=?"+
					"where IDHebergeur="+obj.getIdUser() );
			
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
	public boolean delete(Hebergeur obj) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from Hebergeur where IDHebergeur="+obj.getIdUser();
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
	
	public int getIdHebergeur(String email) {
		
		int idHebergeur = -1;
		Statement myStm;
		
		try {
			myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT IDHebergeur FROM Hebergeur " +
					"WHERE email= '"+email+"'";
		
			ResultSet rs = myStm.executeQuery(q);
			if(rs.first()) {
				idHebergeur = rs.getInt("idHebergeur");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idHebergeur;
	}
	
	public ArrayList<Hebergeur> listHebergeur(){
		ArrayList<Hebergeur> HebergList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Hebergeur";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				Hebergeur hebergeur = new Hebergeur();
				hebergeur.setEmail(rs.getString("email"));
				hebergeur.setNom(rs.getString("nom"));
				hebergeur.setIdUser(rs.getInt("idHebergeur"));
				
				HebergList.add(hebergeur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HebergList;
	
	}
    
}