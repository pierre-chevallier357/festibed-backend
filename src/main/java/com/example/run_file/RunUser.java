package com.example.run_file;
import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_utilisateur.AppInterfaceUser;
import com.example.api_utilisateur.AppRequestFestivalier;
import com.example.api_utilisateur.AppRequestHebergeur;
import com.example.api_utilisateur.AppRequestOrganisateur;
import com.example.utilisateur.Festivalier;

@RestController
@CrossOrigin
@RequestMapping("/user")

public class RunUser {

    static Connection conn;
    AppInterfaceUser requestUser;

    @GetMapping("/test-get-user")
    public Festivalier getUserTesting() {
      Festivalier festivalier = new Festivalier();
      festivalier.setEmail("blabla0gmail.com");
      festivalier.setIdUser(1234);
      festivalier.setNom("PierreLeBG");
      return festivalier;
    }

    @GetMapping("/create-Temp-user/")
    Integer createFestivalier() {
      requestUser = new AppRequestFestivalier();
      int id = ((AppRequestFestivalier) requestUser).createTempUser();      
      return id;
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

    @GetMapping("/connection-Festivalier/{idFestivalier}&{nom}&{email}")
    Integer updateFestivalier(@PathVariable(value = "idFestivalier") Integer id,@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      requestUser = new AppRequestFestivalier();

      requestUser.updateUser(id, nom, email);   
      return id;
    }
    
}
