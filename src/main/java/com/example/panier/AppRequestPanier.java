package com.example.panier;

import java.sql.Connection;
import java.util.ArrayList;
import com.example.DAO.DAO;
import com.example.DAO.PanierDAO;
import com.example.DAO.ProduitDAO;
import com.example.bdConnection.TheConnection;

public class AppRequestPanier implements AppInterfacePanier{
    
    static Connection conn;

    @Override
    public boolean addProduct(Integer idFestivalier, Integer idFestival, Integer idEtablissement, int nbPass){
      boolean res = true;
      conn = TheConnection.getInstance();
      Produit produit = new Produit();
      produit.setIdFestivalier(idFestivalier);
      produit.setIdEtablissement(idEtablissement);
      produit.setIdFestival(idFestival);
      produit.setNbPass(nbPass);
      DAO<Produit> produitDAO = new ProduitDAO(conn);
      produit.setIdFestivalier(idFestivalier);
      if(!produitDAO.create(produit)){
        res = false;
      }
      return res;
    }

    @Override
    public ArrayList<Produit> getProduct(Integer idFestivalier){
      conn = TheConnection.getInstance();
      DAO<Produit> produitDAO = new ProduitDAO(conn);
      return ((ProduitDAO) produitDAO).readlist(idFestivalier);
    }

    public Panier getPanier(Integer idFestivalier){
      conn = TheConnection.getInstance();
      DAO<Panier> panierDAO = new PanierDAO(conn);
      return panierDAO.read(idFestivalier);
    }

    public boolean deleteInPanier(Integer idFestivalier, Integer idFestival, Integer idEtab){
      conn = TheConnection.getInstance();
      DAO<Produit> produitDAO = new ProduitDAO(conn);
      return ((ProduitDAO) produitDAO).deleteProduct(idFestivalier, idFestival, idEtab);

    }

    public boolean delete(Integer idFestivalier){
      conn = TheConnection.getInstance();
      DAO<Produit> produitDAO = new ProduitDAO(conn);
      return ((ProduitDAO) produitDAO).deleteId(idFestivalier);

    }

  public boolean moveToReservation(Integer idFestivalier){

      conn = TheConnection.getInstance();
      DAO<Produit> produitDAO = new ProduitDAO(conn);
      return ((ProduitDAO) produitDAO).moveToReservation(idFestivalier);

  }   

    public Panier getReservation(Integer idFestivalier){
      conn = TheConnection.getInstance();
      DAO<Panier> panierDAO = new PanierDAO(conn);
      return ((PanierDAO) panierDAO).readReservation(idFestivalier);
    }
 
}
