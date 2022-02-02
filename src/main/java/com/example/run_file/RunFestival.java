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

    @GetMapping("/search-festival/{nom}&{ville}&{type}&{departement}&{mois}")
    public ArrayList<Festival> festivalSearch(@PathVariable(value = "nom") String nom, @PathVariable(value = "ville") String ville, @PathVariable(value = "type") String type ,@PathVariable(value = "departement") String departement, @PathVariable(value = "mois") String mois) {
      return requestFestival.getListOfFestival(nom, ville, type, departement, mois);
    }

    @GetMapping("/search-all-festival/")
    public ArrayList<Festival> festivalSearchAll() {
      return requestFestival.getListOfHundredFestival();
    }

    @GetMapping("/get-festival/{idFestival}")
    public Festival getIdFestival(@PathVariable(value = "idFestival") Integer idFestival) {
      return ((AppRequestFestival) requestFestival).getFestivalById(idFestival);
    }
    
}
