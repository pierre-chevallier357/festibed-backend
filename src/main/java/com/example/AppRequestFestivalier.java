package com.example;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.FestivalierDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Festivalier;
import com.example.utilisateur.Utilisateur;

public class AppRequestFestivalier implements AppInterfaceUser {

    static Connection conn;

    @Override
    public int createUser(String nom , String email){
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        Festivalier festivalier = new Festivalier();
        int id = -1;
        festivalier.setNom(nom);
        festivalier.setEmail(email);
        if(!festivalierDAO.create(festivalier)){

            id =  ((FestivalierDAO) festivalierDAO).getIdFestivalier(festivalier.getEmail());
            
            festivalier.setIdUser(id);
            listUserConnect.add(festivalier);
        }
        return id;
    }

    @Override
    public Festivalier getUser(int id){

        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        return festivalierDAO.read(id);

    }

    @Override
    public boolean updateUser(Utilisateur user){
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);
        boolean res = festivalierDAO.update((Festivalier) user);

        return res;
    }

    @Override
    public ArrayList<Utilisateur> getListOfUser(){
        
        conn = TheConnection.getInstance();
        DAO<Festivalier> festivalierDAO = new FestivalierDAO(conn);       
        ArrayList<Festivalier> list =  ((FestivalierDAO) festivalierDAO).listFestivalier();
        ArrayList<Utilisateur> users = cast(list);
        return users;
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<Utilisateur> cast(ArrayList<T> list) {
        return (ArrayList<Utilisateur>) list;
    }
    
}
