package com.example;



import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.DAO;
import com.example.DAO.FestivalierDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Festivalier;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HttpTest {
    static Connection conn;
    
    DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
    
    @GetMapping("/")
    public String indexUser() {
      
     conn = TheConnection.getInstance();

      Festivalier festivalier = new Festivalier();
      festivalier = festivalierDAO.read(7);

      String s = festivalier.getNom() +"   ID : "+ festivalier.getIdUser();
      return s;
      //return "Ceci est le serveur";
    }

    @GetMapping("/create-Festivalier/{nom}&{email}")
    Integer createFestivalier(@PathVariable(value = "nom") String nom, @PathVariable(value = "email") String email) {
      Festivalier festivalier = new Festivalier();
      festivalier.setNom(nom);
      festivalier.setEmail(email);
      festivalierDAO.create(festivalier);
      festivalier.setIdUser(((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail()));

      
      return festivalier.getIdUser();
    }
  
}
