package com.example.run_file; 

import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.panier.AppInterfacePanier;
import com.example.panier.AppRequestPanier;
import com.example.panier.Produit;

@RestController
@CrossOrigin
@RequestMapping("/panier")
public class RunPanier {

    static Connection conn;
    AppInterfacePanier requestPanier = new AppRequestPanier();

    @GetMapping("/first-product/{idFestivalier}&{product}")
    public Integer firstProductCreatePanier(@PathVariable(value = "idFestivalier") Integer idFestivalier, @PathVariable(value = "product") Produit produit) {
      return requestPanier.createPanier(idFestivalier, produit);
    }

    @GetMapping("/add-product/{idPanier}&{product}")
    public boolean addProduct(@PathVariable(value = "idPanier") Integer idPanier, @PathVariable(value = "product") Produit produit) {
      requestPanier.addProduct(idPanier, produit);
      return true;
    }
    
}
