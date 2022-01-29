package com.example.panier;

import com.example.Tools;

public class Produit {
    Integer idProduit;
    Integer idFestivalier;
    Integer idFestival;
    Integer idEtablissement;
    int nbPass;

    public Integer getIdFestivalier() {
        return this.idFestivalier;
    }

    public void setIdFestivalier(Integer idFestivalier) {
        this.idFestivalier = idFestivalier;
    }

    public Integer getIdFestival() {
        return this.idFestival;
    }

    public void setIdFestival(Integer idFestival) {
        this.idFestival = idFestival;
    }

    public Integer getIdEtablissement() {
        return this.idEtablissement;
    }

    public void setIdEtablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public int getNbPass() {
        return this.nbPass;
    }

    public void setNbPass(int nbPass) {
        this.nbPass = nbPass;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void createIdProduit() {
        this.idProduit = Tools.randomNum();
    }

    public void setIdProduit(Integer id){
        this.idProduit = id;
    }

    
}
