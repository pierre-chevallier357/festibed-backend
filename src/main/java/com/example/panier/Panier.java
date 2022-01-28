package com.example.panier;

import java.util.ArrayList;

public class Panier {

    ArrayList<Produit> listProduit = new ArrayList<>();
    

    Integer idFestivalier;

    public void addProduct(Produit produit){

        listProduit.add(produit);
    }

    public Integer getIdFestivalier() {
        return this.idFestivalier;
    }

    public void setIdFestivalier(Integer idFestivalier) {
        this.idFestivalier = idFestivalier;
    }


    public Panier factoryPanier(ArrayList<Panier> listPanier, Integer idFestivalier){
        Panier resPanier = null;
        for(Panier panier : listPanier){
            if(panier.getIdFestivalier().equals(idFestivalier)){
                resPanier = panier;
            }
        }
        if(resPanier == null){
            resPanier = new Panier();
            resPanier.setIdFestivalier(idFestivalier);
        }
        return resPanier;
    }
    
}
