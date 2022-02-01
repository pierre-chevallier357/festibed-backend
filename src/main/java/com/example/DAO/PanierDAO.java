package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.panier.Panier;
import com.example.panier.Produit;

public class PanierDAO extends DAO<Panier> {

    public PanierDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Panier obj) {
		
		int ins = 0;

		try {
            for(Produit produit : obj.getProductInPanier()){
                PreparedStatement prepare = this.connect.prepareStatement(
					"insert into Panier(idPanier,idProduit,HeureDernierProduit,nbPass)"+
					"values(?,?,?,?)"
					);
			
			    prepare.setInt(1, obj.getIdPanier());
                prepare.setInt(2, produit.getIdProduit());
                prepare.setString(3, "00h00");
                prepare.setInt(4, produit.getNbPass());
                

			    ins = prepare.executeUpdate();

            }
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override	
	public Panier read(int id) {	
			Statement myStm;
			 
			Panier panier = new Panier();
			Produit produit = new Produit();
			try {
				String q = 	"SELECT * FROM Panier " +
						"WHERE IDPanier="+id;
				myStm = this.connect.createStatement(this.type,this.mode);
				
				ResultSet rs = myStm.executeQuery(q);
				while(rs.next()) {
                    panier.setIdPanier(rs.getInt("idPanier"));
                    produit.setIdProduit(rs.getInt("idProduit"));
                    produit = getProduit(produit.getIdProduit());
                    produit.setNbPass(rs.getInt("nbPass"));
                    panier.addProduct(produit);
				}
				
			}
				
			catch (SQLException e) {
				e.printStackTrace();
                
			}
			return panier;
	}

	@Override
	public boolean update(Panier obj) {
		
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
	public boolean delete(Panier obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFesti = "delete from Panier where IDPanier="+obj.getIdPanier();
			del = myStm.executeUpdate(supFesti);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}
	
	public Produit getProduit(Integer idProduit){
        Produit produit = new Produit();
        try{
            
            Statement myStm = this.connect.createStatement(this.type,this.mode);
            String q = 	"SELECT * FROM Produit WHERE idProduit = "+idProduit;
            ResultSet rs = myStm.executeQuery(q);
            if(rs.first()){
                produit.setIdProduit(rs.getInt("idProduit"));
                produit.setIdEtablissement(rs.getInt("idEtablissement"));
                produit.setIdFestival(rs.getInt("idFestival"));
                produit.setIdFestivalier(rs.getInt("idFestivalier"));
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return produit;
    }
}
