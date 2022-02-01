package com.example.run_file;
import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tools;
import com.example.api_festival.AppInterfaceFestival;
import com.example.api_festival.AppRequestFestival;
import com.example.api_festival.Festival;

@RestController
@CrossOrigin
@RequestMapping("/festival")

public class RunFestival {

    
    static Connection conn;
    AppInterfaceFestival requestFestival = new AppRequestFestival();

    @GetMapping("/")
    public Integer getIdTemp() {
      Integer id;
      id = Tools.randomNum();
      return id;
    }

    @GetMapping("/search-festival-name/{nom}")
    public ArrayList<Festival> festivalSearchByNom(@PathVariable(value = "nom") String nom) {
      return requestFestival.getListOfFestival(1, nom);
    }
    
    @GetMapping("/search-festival-ville/{ville}")
    public ArrayList<Festival> festivalSearchByVille(@PathVariable(value = "ville") String ville) {
      return requestFestival.getListOfFestival(2, ville);
    }

    @GetMapping("/search-festival-departement/{departement}")
    public ArrayList<Festival> festivalSearchByDepartement(@PathVariable(value = "departement") String departement) {
      return requestFestival.getListOfFestival(3, departement);
    }

    @GetMapping("/search-festival-type/{type}")
    public ArrayList<Festival> festivalSearchByType(@PathVariable(value = "type") String type) {
      return requestFestival.getListOfFestival(4, type);
    }

    @GetMapping("/search-festival-type-complement/{type}&{complement}")
    public ArrayList<Festival> festivalSearchByTypeAndComplement(@PathVariable(value = "type") String type, @PathVariable(value = "type") String complement) {

      return requestFestival.getListOfFestival(5, type+"&"+complement);
    }

    @GetMapping("/search-all-festival/")
    public ArrayList<Festival> festivalSearchAll() {
      return requestFestival.getListOfFestival(6, "null");
    }

    @GetMapping("/search-festival-month/{mois}")
    public ArrayList<Festival> festivalSearchByMonth(@PathVariable(value = "mois") String mois) {
      return requestFestival.getListOfFestival(7, mois);
    }

    
}
