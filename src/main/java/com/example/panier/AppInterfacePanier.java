package com.example.panier;

import java.util.ArrayList;

public interface AppInterfacePanier {
    
    ArrayList<Panier> listPanier = new ArrayList<>();
    public boolean addProduct(Integer idFestivalier, Produit produit);
    public Integer createPanier(Integer idFestivalier, Produit produit);
    public ArrayList<Produit> getProduct(Integer idPanier);
    
}
