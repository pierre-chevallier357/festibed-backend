package com.example.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.utilisateur.Festivalier;


public class FestivalierDAO extends DAO<Festivalier> {
    
    public FestivalierDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Festivalier obj) {
		
		boolean res = false;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Festivalier(nom,email)"+
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

	public boolean createTempFestivalier(String tempEmail) {
		
		boolean res = false;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Festivalier(nom,email)"+
					"values(?,?)"
					);
			
			prepare.setString(1, "tempUser");
			prepare.setString(2, tempEmail);

			prepare.executeUpdate();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
		
	public Festivalier read(int id) {
		
		Festivalier festivalier = new Festivalier();		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festivalier " +
						"WHERE IDFestivalier="+id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				festivalier.setEmail(rs.getString("email"));
				festivalier.setNom(rs.getString("nom"));
				festivalier.setIdUser(rs.getInt("idFestivalier"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return festivalier;
	}

	@Override
	public boolean update(Festivalier obj) {
		
		boolean res = true; 
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update Festivalier set nom=?, email=?"+
					"where IDFestivalier="+obj.getIdUser() );
			
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
	public boolean delete(Festivalier obj) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from Festivalier where IDFestivalier="+obj.getIdUser();
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
	
	public int getIdFestivalier(String email) {
		
		int idFestivalier = -1;
		Statement myStm;
		
		try {
			myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT IDFestivalier FROM Festivalier " +
					"WHERE email= '"+email+"'";
		
			ResultSet rs = myStm.executeQuery(q);
			if(rs.first()) {
				idFestivalier = rs.getInt("idFestivalier");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idFestivalier;
	}
	
	public ArrayList<Festivalier> listFestivalier(){
		ArrayList<Festivalier> festiList = new ArrayList<>();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM Festivalier";
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				Festivalier festivalier = new Festivalier();
				festivalier.setEmail(rs.getString("email"));
				festivalier.setNom(rs.getString("nom"));
				festivalier.setIdUser(rs.getInt("idFestivalier"));
				
				festiList.add(festivalier);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return festiList;
	
	}

	public Integer find(String email, String password) {
			
		Integer id = null;

		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT idFestivalier FROM Festivalier " +
						"WHERE email= '"+email+"' and password= '"+password+"'";
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				id = rs.getInt("idFestivalier");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}


	public boolean deleteUser(Integer id) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from Festivalier where IDFestivalier="+id;
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
}
