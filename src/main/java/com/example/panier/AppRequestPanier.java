package com.example.panier;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.Tools;
import com.example.DAO.PanierDAO;

public class AppRequestPanier implements AppInterfacePanier{


    Panier panier;
    
    static Connection conn;

    @Override
    public Integer createPanier(Integer idFestivalier, Produit produit){
        PanierDAO panierDAO = new PanierDAO(conn);
        Panier panier = new Panier();
        panier.setIdFestivalier(idFestivalier);
        produit.createIdProduit();
        panier.addProduct(produit);
        Integer i = Tools.randomNum();
        for (Panier p : listPanier) {
          while(p.getIdPanier().equals(i)){
            i = Tools.randomNum();
          }
        }
        panier.setIdPanier(i);
        
        panierDAO.create(panier);
        listPanier.add(panier);
        return i;
    }

    @Override
    public boolean addProduct(Integer idPanier, Produit produit){
        Panier panier = Tools.panierDansList(listPanier, idPanier);
        PanierDAO panierDAO = new PanierDAO(conn);
        produit.createIdProduit();
        panier.addProduct(produit);
        //panierDAO.addProductInPanier(panier, produit);
        return true;
    }

    @Override
    public ArrayList<Produit> getProduct(Integer idPanier){
        Panier panier = Tools.panierDansList(listPanier, idPanier);
        return panier.getProductInPanier();
    }

    public Panier getPanier(Integer idPanier){
      return Tools.panierDansList(listPanier, idPanier);
    }


    public Produit getFistProduit(Integer idPanier){
      Panier panier = Tools.panierDansList(listPanier, idPanier);
      return panier.getFirstProductInPanier();
        
      
    }

    
}
