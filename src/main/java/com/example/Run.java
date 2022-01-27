package com.example;



import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.DAO;
import com.example.DAO.FestivalierDAO;
import com.example.DAO.HebergeurDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Festivalier;
import com.example.utilisateur.Hebergeur;

@CrossOrigin
@RestController
@RequestMapping("/")
public class Run {


    static Connection conn;
    
    @GetMapping("/")
    public Festivalier indexUser() {
     conn = TheConnection.getInstance();

      DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
      Festivalier festivalier = new Festivalier();
      festivalier = festivalierDAO.read(7);
      Tools.connClose(conn);
      return festivalier;
    }

    @GetMapping("/test-get-user")
    public Festivalier getUserTesting() {
      Festivalier festivalier = new Festivalier();
      festivalier.setEmail("blabla0gmail.com");
      festivalier.setIdUser(1234);
      festivalier.setNom("PierreLeBG");
      return festivalier;
    }
/*
    @GetMapping("/create-Festivalier/{nom}&{email}")
    Integer createFestivalier(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      
      conn = TheConnection.getInstance();
      DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
      Festivalier festivalier = new Festivalier();
      festivalier.setNom(nom);
      festivalier.setEmail(email);
      festivalierDAO.create(festivalier);
      festivalier.setIdUser(((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail()));
      return festivalier.getIdUser();
    }


    @GetMapping("/create-Hebergeur/{nom}&{email}")
    Integer createHebergeur(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      
      conn = TheConnection.getInstance();
      DAO<Hebergeur> hebergeurDAO = new HebergeurDAO(conn);
      Hebergeur hebergeur = new Hebergeur();
      hebergeur.setNom(nom);
      hebergeur.setEmail(email);
      hebergeurDAO.create(hebergeur);
      hebergeur.setIdUser(((HebergeurDAO) hebergeurDAO).getIdHebergeur(hebergeur.getEmail()));

      
      return hebergeur.getIdUser();
    }

*/
  
}
