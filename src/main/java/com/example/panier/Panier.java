package com.example.panier;

import java.util.ArrayList;

public class Panier {

    ArrayList<Produit> listProduit = new ArrayList<>();
    
    Integer idFestivalier;

    Integer idPanier;

    public Integer getIdPanier() {
        return this.idPanier;
    }

    public void setIdPanier(Integer idPanier) {
        this.idPanier = idPanier;
    }

    public void addProduct(Produit produit){

        listProduit.add(produit);
    }

    public Integer getIdFestivalier() {
        return this.idFestivalier;
    }

    public void setIdFestivalier(Integer idFestivalier) {
        this.idFestivalier = idFestivalier;
    }




    /*public Panier factoryPanier(ArrayList<Panier> listPanier, Integer idFestivalier){
        
        System.out.println("here");
        boolean res = false;
        Panier resPanier;
        
        for(Panier panier : listPanier){
            if(panier.getIdFestivalier().equals(idFestivalier)){
                resPanier = panier;
                res = true;
            }
        }
        if(res == false){
            resPanier = new Panier();
            resPanier.setIdFestivalier(idFestivalier);
        }
        else{
            resPanier = null;
        }
        return resPanier;
    }*/

    public ArrayList<Produit> getProductInPanier(){
        return listProduit;
    }
    
}
