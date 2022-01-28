package com.example;



import java.sql.Connection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.DAO;
import com.example.DAO.FestivalDAO;
import com.example.DAO.FestivalierDAO;
import com.example.DAO.HebergeurDAO;
import com.example.bdConnection.TheConnection;
import com.example.other.Festival;
import com.example.utilisateur.Festivalier;
import com.example.utilisateur.Hebergeur;

@CrossOrigin
@RestController
@RequestMapping("/")
public class Run {


    static Connection conn;
    AppInterfaceUser requestUser;
    
    @GetMapping("/reach-festival-ville/{ville}")
    public ArrayList<Festival> festivalReachByVille(@PathVariable(value = "ville") String ville) {
      conn = TheConnection.getInstance();

      DAO<Festival> festivalDAO = new FestivalDAO(conn);
      ArrayList<Festival> festivalier = new ArrayList<>();
      festivalier = ((FestivalDAO) festivalDAO).listFestivalReachByVille(ville);
      return festivalier;
    }

    @GetMapping("/reach-festival-type/{type}")
    public ArrayList<Festival> festivalReachByType(@PathVariable(value = "type") String type) {
      conn = TheConnection.getInstance();

      DAO<Festival> festivalDAO = new FestivalDAO(conn);
      ArrayList<Festival> festivalier = new ArrayList<>();
      festivalier = ((FestivalDAO) festivalDAO).listFestivalReachByType("type");
      Tools.connClose(conn);
      return festivalier;
    }

    @GetMapping("/reach-festival-type/{departement}")
    public ArrayList<Festival> festivalReachByDepartement(@PathVariable(value = "departement") String departement) {
      conn = TheConnection.getInstance();

      DAO<Festival> festivalDAO = new FestivalDAO(conn);
      ArrayList<Festival> festivalier = new ArrayList<>();
      festivalier = ((FestivalDAO) festivalDAO).listFestivalReachByDepartement(departement);
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
  
    @GetMapping("/create-Hebergeur/{nom}&{email}")
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
