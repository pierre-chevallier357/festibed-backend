/*package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.logement.Logement;

public class LogementDAO extends DAO<Logement> {

    public LogementDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Logement obj) {
		
		boolean res = true; 

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesAdresses(noRue,nomRue,ville,CodePostal,IDclient)"+
					"values(?,?,?,?,?)"
					);
			
			prepare.setInt(1, obj.getNumRue());
			prepare.setString(2, obj.getNomRue());
			prepare.setString(3, obj.getVille());
			prepare.setInt(4, obj.getCodePostal());
			prepare.setInt(5,obj.getIdClient());

			prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}
		
	public Logement read(int id) {
		
		Logement logement = new Logement();		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesAdresses " +
						"WHERE IDclient="+id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				//logement = new Logement(rs.getInt("noRue"),rs.getString("nomRue"),
				//		rs.getString("ville"),rs.getInt("CodePostal"),id);		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return logement;
	}

	@Override
	public boolean update(Logement obj) {
		
		boolean res = true; 
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesAdresses set noRue=?, nomRue=?, ville=?, CodePostal=?"+
					"where IDclient="+obj.getIdClient() );
			
			prepare.setInt(1, obj.getNumRue());
			prepare.setString(2, obj.getNomRue());
			prepare.setString(3, obj.getVille());
			prepare.setInt(4, obj.getCodePostal());
				    		
			prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}

	@Override
	public boolean delete(Logement obj) {
		
		boolean res = true; 
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from LesAdresses where IDclient="+obj.getIdClient();
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}
		
		return res;
	}
    
}*/

