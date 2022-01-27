package com.example;



import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/")
    public String indexUser() {
      
     conn = TheConnection.getInstance();

      DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
      Festivalier festivalier = new Festivalier();
      festivalier = festivalierDAO.read(7);

      String s = festivalier.getNom() +"   ID : "+ festivalier.getIdUser();
      return s;
      //return "Ceci est le serveur";
    }

    @GetMapping("/ping")
    String db() {
      return "pong";
    }
  
}
