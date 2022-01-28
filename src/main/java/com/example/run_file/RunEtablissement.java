package com.example.run_file; 

import java.sql.Connection;
import java.util.ArrayList;

import com.example.api_etablissement.AppInterfaceEtablissement;
import com.example.api_etablissement.AppRequestEtablissement;
import com.example.etablissement.Etablissement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/etablissement")
public class RunEtablissement {

    static Connection conn; 
    
    AppInterfaceEtablissement requestEtab = new AppRequestEtablissement();  

    @GetMapping("/search-by-name/{idFestival}&{nom}&{type}")
    public ArrayList<Etablissement> festivalsearchByNom(@PathVariable(value = "idFestival") Integer idFestival, @PathVariable(value = "nom") String nom, @PathVariable(value = "type") String type) {
      return requestEtab.getListOfEtablissement(idFestival, type, 1, nom);
    }
    
    @GetMapping("/search-by-ville/{idFestival}&{ville}&{type}")
    public ArrayList<Etablissement> festivalsearchByVille(@PathVariable(value = "idFestival") Integer idFestival,@PathVariable(value = "ville") String ville, @PathVariable(value = "type") String type) {
        return requestEtab.getListOfEtablissement(idFestival, type, 2, ville);
    }

    @GetMapping("/search-by-type/{idFestival}&{type}")
    public ArrayList<Etablissement> festivalsearchByDepartement(@PathVariable(value = "idFestival") Integer idFestival, @PathVariable(value = "type") String type) {
      return requestEtab.getListOfEtablissement(idFestival, type, 3, "null");
    }

    
}
