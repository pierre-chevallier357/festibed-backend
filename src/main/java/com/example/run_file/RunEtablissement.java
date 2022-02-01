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


@RestController
@CrossOrigin
@RequestMapping("/etablissement")
public class RunEtablissement {

    static Connection conn; 
    
    AppInterfaceEtablissement requestEtab = new AppRequestEtablissement();  

    @GetMapping("/search-etablissement/{idFestival}&{nom}&{type}&{ville}")
    public ArrayList<Etablissement> etablissementSearchByNom(@PathVariable(value = "idFestival") Integer idFestival, @PathVariable(value = "nom") String nom, @PathVariable(value = "type") String type, @PathVariable(value = "ville") String ville) {
      return requestEtab.getListOfEtablissement(idFestival, nom, type, ville);
    }

}
