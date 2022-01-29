package com.example.panier;

import java.util.ArrayList;

import com.example.Tools;

public class AppRequestPanier implements AppInterfacePanier{


    Panier panier;

    @Override
    public Integer createPanier(Integer idFestivalier, Produit produit){

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
        listPanier.add(panier);
        return i;
    }

    @Override
    public boolean addProduct(Integer idPanier, Produit produit){
        Panier panier = Tools.panierDansList(listPanier, idPanier);
        produit.createIdProduit();
        panier.addProduct(produit);
        return true;
    }

    @Override
    public ArrayList<Produit> getProduct(Integer idPanier){
        Panier panier = Tools.panierDansList(listPanier, idPanier);
        return panier.getProductInPanier();
    }

    
}
