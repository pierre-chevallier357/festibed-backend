package com.example.run_file; 

import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add-product/{idFestivalier}&{idFestival}&{idEtablissment}&{nbPass}")
    public boolean addProduct(@PathVariable(value = "idFestivalier") Integer idFestivalier, @PathVariable(value = "idFestival") Integer idFestival, @PathVariable(value = "idEtablissement") Integer idEtablissement, @PathVariable(value = "nbPass") int nbPass) {
      boolean res = true;
      System.out.println(idFestivalier+ "-----"+ idEtablissement);
      res = requestPanier.addProduct(idFestivalier, idFestival, idEtablissement, nbPass);
      return res;
    }

    @GetMapping("/get-panier/{idFestivalier}")
    public ArrayList<Produit> getPanier(@PathVariable(value = "idFestivalier") Integer idFestivalier) {
      return requestPanier.getPanier(idFestivalier).getProductInPanier();
    }
    
}
