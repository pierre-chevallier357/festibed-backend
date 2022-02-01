package com.example.panier;

import java.util.ArrayList;

public interface AppInterfacePanier {
    
    public boolean addProduct(Integer idFestivalier, Produit produit);
    public ArrayList<Produit> getProduct(Integer idFestivalier);
    public Panier getPanier(Integer idFestivalier);
    
}
