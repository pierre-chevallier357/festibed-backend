package com.example;



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
import com.example.utilisateur.AppInterfaceUser;
import com.example.utilisateur.AppRequestFestivalier;
import com.example.utilisateur.AppRequestHebergeur;
import com.example.utilisateur.AppRequestOrganisateur;
import com.example.utilisateur.Festivalier;
import com.example.utilisateur.Hebergeur;

@CrossOrigin
@RestController
@RequestMapping("/")
public class Run {


    static Connection conn;
    AppInterfaceUser requestUser;
    AppInterfaceFestival requestFestival = new AppRequestFestival();

    @GetMapping("/")
    public String index() {
      return "ceci est le serveur";
    }

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

    @GetMapping("/reach-festival-type-complement/{type}")
    public ArrayList<Festival> festivalReachByTypeAndComplement(@PathVariable(value = "type") String type) {
      return requestFestival.getListOfFestival(5, type);
    }



    @GetMapping("/test-get-user")
    public Festivalier getUserTesting() {
      Festivalier festivalier = new Festivalier();
      festivalier.setEmail("blabla0gmail.com");
      festivalier.setIdUser(1234);
      festivalier.setNom("PierreLeBG");
      return festivalier;
    }


    @GetMapping("/create-Festivalier/{nom}&{email}")
    Integer createFestivalier(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      requestUser = new AppRequestFestivalier();
      int id = requestUser.createUser(nom, email);      
      return id;
    }


    @GetMapping("/create-Hebergeur/{nom}&{email}")
    Integer createHebergeur(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      
      requestUser = new AppRequestHebergeur();
      int id = requestUser.createUser(nom, email);      
      return id;
    }
  
    @GetMapping("/create-Organisateur/{nom}&{email}")
    Integer createOrganisateur(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      
      requestUser = new AppRequestOrganisateur();
      int id = requestUser.createUser(nom, email);      
      return id;
    }

    @GetMapping("/connection-close")
    void connectionClose(){
      Tools.connClose(conn);
    }
}
