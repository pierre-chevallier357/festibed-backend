package com.example.DAO;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.panier.Produit;

public class ProduitDAO extends DAO<Produit> {

    public ProduitDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Produit obj) {
		
		int ins = 0;

		try {
			for (int i = 0; i < obj.getNbPass(); i++){
				PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Panier(idFestivalier, idEtablissement, idFestival, nbPass, HEUREDERNIEREMODIF)"+
						"values(?,?,?,?,?)"
					);
			
				prepare.setInt(1, obj.getIdFestivalier());
				prepare.setInt(2, obj.getIdEtablissement());
				prepare.setInt(3, obj.getIdFestival());
				prepare.setInt(4, 1);
				Date time = new Date();

				DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
				prepare.setString(5, shortDateFormat.format(time));

				ins = prepare.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
        }
		return ins > 0;
	}

	@Override	
	public Produit read(int id) {	
			Statement myStm;
			 
			Produit produit = new Produit();
			try {
				String q = 	"SELECT * FROM Panier " +
						"WHERE IdFestivalier="+id;
				myStm = this.connect.createStatement(this.type,this.mode);
				
				ResultSet rs = myStm.executeQuery(q);
				while(rs.next()) {
                    produit.setIdFestivalier(rs.getInt("idFestivalier"));
                    produit.setIdEtablissement(rs.getInt("idEtablissement"));
                    produit.setIdFestival(rs.getInt("idFestival"));
                    produit.setNbPass(rs.getInt("nbPass"));
				}
				
			}
				
			catch (SQLException e) {
				e.printStackTrace();
                
			}
			return produit;
	}

	@Override
	public boolean update(Produit obj) {
		
		int upd = 0;
	/*	
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update FESTIVAL set siteInternet,Commentaire"+
					"where IDEtab="+obj.getIdFestival() );
			
			prepare.setString(1, obj.getSiteInternet());
			
			prepare.setString(2, obj.getCommentaire());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}*/
		
		return upd > 0;
	}

	@Override
	public boolean delete(Produit obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFesti = "delete from Produit where IDFestivalier="+obj.getIdFestivalier();
			del = myStm.executeUpdate(supFesti);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}


	public ArrayList<Produit> readlist(int id) {	
		ArrayList<Produit> produitList = new ArrayList<>();

		Statement myStm;
		try {
			String q = 	"SELECT * FROM Panier " +
					"WHERE IdFestivalier="+id;
			myStm = this.connect.createStatement(this.type,this.mode);
			
			ResultSet rs = myStm.executeQuery(q);
			while(rs.next()) {
				Produit produit = new Produit();
				produit.setIdFestivalier(rs.getInt("idFestivalier"));
				produit.setIdEtablissement(rs.getInt("idEtablissement"));
				produit.setIdFestival(rs.getInt("idFestival"));
				produit.setNbPass(rs.getInt("nbPass"));
				produitList.add(produit);
			}

				
		}
			
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		return produitList;
	}
	


	public boolean deleteProduct(Integer idFestivalier, Integer idFestival, Integer idEtab) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFesti = "delete from Produit where IDFestivalier="+idFestivalier+" AND idFestival = "+idFestival+" AND idEtablissement ="+idEtab;
			del = myStm.executeUpdate(supFesti);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

	public boolean deleteId(Integer idFestivalier) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFesti = "delete from Produit where IDFestivalier="+idFestivalier;
			del = myStm.executeUpdate(supFesti);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

	public boolean moveToReservation(int idFestivalier) {
		int ins = 0;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("insert into Panier(idFestivalier, idEtablissement, idFestival, nbPass) values (SELECT idFestivalier, idEtablissement, idFestival, nbPass FROM Panier WHERE IdFestivalier="+idFestivalier+")");
			ins = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
        }
		return ins>0;
	}
	
}