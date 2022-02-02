package com.example.other;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.DAO.*;
import com.example.api_festival.AppInterfaceFestival;
import com.example.api_festival.AppRequestFestival;
import com.example.api_festival.Festival;
import com.example.api_utilisateur.AppInterfaceUser;
import com.example.api_utilisateur.AppRequestFestivalier;
import com.example.etablissement.*;
import com.example.panier.AppInterfacePanier;
import com.example.panier.AppRequestPanier;
import com.example.panier.Panier;
import com.example.panier.Produit;
import com.example.utilisateur.*;
import com.example.bdConnection.*;


public class Main {
    static Connection conn;
    public static void main(String args[]) {
        conn = TheConnection.getInstance();

       //FestivalDAO festivalDAO ;
        /* DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        ArrayList<Etablissement> list = ((EtablissementDAO) etablissementDAO).listEtab(1, "H�TEL");

        for (Etablissement etab : list) {
            System.out.println(etab.getNomCommercial()); 
        }
        System.out.println("---------------------L'HOTEL ID :12379  --------------------------");
        
        Etablissement etabById = ((EtablissementDAO) etablissementDAO).read(12379);
        
        System.out.println(etabById.getNomCommercial()); 

        System.out.println("---------------------AU REVOIR --------------------------");
        
       
        DAO<Festival> festivalDAO = new FestivalDAO(conn);

        System.out.println("---------------------Le Festival par ville  --------------------------");
        
       
        ArrayList<Festival> listFesti = ((FestivalDAO) festivalDAO).searchFestivalsByVille("REIMS");

        for (Festival festi : listFesti) {
            System.out.println(festi.getNom()); 
        }
        
        
        System.out.println("---------------------Le Festival par departement  --------------------------");
        
        ArrayList<Festival> listDep = ((FestivalDAO) festivalDAO).listFestivalReachByDepartement("Bouches-du-Rh�ne");

        for (Festival festi : listDep) {
            System.out.println(festi.getNom()); 
        }
        
        System.out.println("---------------------Le Festival ID :111  --------------------------");
        
        Festival festibyId = ((FestivalDAO) festivalDAO).read(111);
        
        System.out.println(festibyId.getLocalisation().getCommune()); 
        

        System.out.println("---------------------Le Festival de Musique Classique  --------------------------");
        
        DAO<Festival> festivalDAO = new FestivalDAO(conn);
        //ArrayList<Festival> listDomaine = ((FestivalDAO) festivalDAO).searchFestivalsByVille("REIMS");
        AppInterfaceFestival requestFestival = new AppRequestFestival();
        ArrayList<Festival> listDomaine = requestFestival.getListOfFestival(1,"AU COEUR DE COSNE");
    	
        for (Festival festi : listDomaine) {
            System.out.println(festi.getNom()); 
        }
        */
        
       /*
        System.out.println("---------------------Le Festival de Musique Classique voir ces  domaines  --------------------------");
        
        
        ArrayList<Festival> listComp = ((FestivalDAO) festivalDAO).listFestivalReachByType("Musiques classiques");
    	
        for (Festival festi : listComp) {
        	if (festi.getComplementDomaine() != null) {
        		System.out.println(festi.getComplementDomaine() +"   ID : "+ festi.getIdFestival()); 
        	}
        }
        
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        
        Festivalier festivalier = new Festivalier();
        festivalier.setEmail("mounir@gmail.com");
        festivalier.setNom("MIKL");
       
        festivalierDAO.create(festivalier);
        

        int id = ((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail());
        //System.out.println("---------------------ID GENERER : "+id+" --------------------------");
        
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = new Festivalier();
        festivalier = festivalierDAO.read(7); 
        
        System.out.println(festivalier.getNom() +" Email : "+festivalier.getEmail());
        ArrayList<Festivalier> listFestivalier;
        listFestivalier = ((FestivalierDAO) festivalierDAO).listFestivalier();
        for (Festivalier festi : listFestivalier) {
        	System.out.println(festi.getNom() +"   ID : "+ festi.getIdUser()); 
        }
        System.out.println("---------------------AU REVOIR --------------------------");
    
        try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
*/
        AppInterfacePanier panier = new AppRequestPanier();

       /* Produit produit = new Produit();
        int idFestivalier = 1;
        produit.createIdProduit();
        produit.setIdEtablissement(1);
        produit.setIdFestival(1186);
        produit.setIdFestivalier(1);
        produit.setNbPass(1);*/
        panier.addProduct(194, 1, 243,1);

        ArrayList<Produit> produitList = panier.getProduct(194);
        for (Produit prod : produitList){
            System.out.println(prod.getIdFestivalier());
        }
/*
    
    AppInterfaceUser userReq =  new AppRequestFestivalier();

    int id = ((AppRequestFestivalier) userReq).createTempUser();
    System.out.println(id);     

*/ /*
    DAO<Festival> festivalDAO = new FestivalDAO(conn);
    String nom ="LÉZART VERT",  ville="null",  type="null",  departement="null",  mois="null";

        ArrayList<Festival> listF = new ArrayList<>();

        listF =  ((FestivalDAO) festivalDAO).searchFestivals( nom,  ville,  type,  departement,  mois);
        for(Festival fes : listF){
            System.out.println(fes.getNom()+" type : "+fes.getDepartement());
        }

/*
        EtablissementDAO etabDAO = new EtablissementDAO(conn);
        String nom ="null",  ville="MARSEILLE",  type="HOTEL";
        ArrayList<Etablissement> listE = new ArrayList<>();
        listE =  etabDAO.searchEtablissement(2, nom, type, ville);
        for(Etablissement etab : listE){
            System.out.println(etab.getNom()+" type : "+etab.getCommune());
        }

        //ProduitDAO produitDAO= new ProduitDAO(conn);
        AppInterfacePanier panier = new AppRequestPanier();
        ArrayList<Produit> listProd = new ArrayList<>();
        
       listProd=  panier.getProduct(1186);

       for(Produit prod : listProd){
        System.out.println(prod.getIdEtablissement()+" idfestivalier : "+prod.getIdFestivalier());
        }
*/
    }


}
