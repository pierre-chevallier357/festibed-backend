package com.example.run_file;
import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_festival.AppInterfaceFestival;
import com.example.api_festival.AppRequestFestival;
import com.example.api_festival.Festival;

@CrossOrigin
@RestController
@RequestMapping("/festival")

public class RunFestival {

    
    static Connection conn;
    AppInterfaceFestival requestFestival = new AppRequestFestival();
    @GetMapping("/reach-festival-name/{nom}")
    public ArrayList<Festival> festivalReachByNom(@PathVariable(value = "nom") String nom) {
      return requestFestival.getListOfFestival(1, nom);
    }
    
    @GetMapping("/reach-festival-ville/{ville}")
    public ArrayList<Festival> festivalReachByVille(@PathVariable(value = "ville") String ville) {
      return requestFestival.getListOfFestival(2, ville);
    }

    @GetMapping("/reach-festival-type/{departement}")
    public ArrayList<Festival> festivalReachByDepartement(@PathVariable(value = "departement") String departement) {
      return requestFestival.getListOfFestival(3, departement);
    }

    @GetMapping("/reach-festival-type/{type}")
    public ArrayList<Festival> festivalReachByType(@PathVariable(value = "type") String type) {
      return requestFestival.getListOfFestival(4, type);
    }

    @GetMapping("/reach-festival-type-complement/{type}&{complement}")
    public ArrayList<Festival> festivalReachByTypeAndComplement(@PathVariable(value = "type") String type, @PathVariable(value = "type") String complement) {

      return requestFestival.getListOfFestival(5, type+"&"+complement);
    }

    
}
