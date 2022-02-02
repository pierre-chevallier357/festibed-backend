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
    public boolean addProduct(Integer idFestivalier, Produit produit){
      boolean res = true;
      conn = TheConnection.getInstance();
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

    
}
