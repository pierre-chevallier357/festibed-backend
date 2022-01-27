package com.example;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.OrganisateurDAO;
import com.example.bdConnection.TheConnection;
import com.example.utilisateur.Organisateur;
import com.example.utilisateur.Utilisateur;

public class AppRequestOrganisateur implements AppInterfaceUser{


    static Connection conn;

    @Override
    public int createUser(String nom , String email){
        conn = TheConnection.getInstance();
        DAO<Organisateur> OrganisateurDAO = new OrganisateurDAO(conn);
        Organisateur Organisateur = new Organisateur();
        int id = -1;
        Organisateur.setNom(nom);
        Organisateur.setEmail(email);
        if(!OrganisateurDAO.create(Organisateur)){

            id =  ((OrganisateurDAO) OrganisateurDAO).getIdOrganisateur(Organisateur.getEmail());
            
            Organisateur.setIdUser(id);
            listUserConnect.add(Organisateur);
        }
        Tools.connClose(conn);
        return id;
    }

    @Override
    public Organisateur getUser(int id){
        
        conn = TheConnection.getInstance();
        DAO<Organisateur> organisateurDAO = new OrganisateurDAO(conn);
        Organisateur organisateur =  organisateurDAO.read(id);
        Tools.connClose(conn);
        return organisateur;
    }
    
    @Override
    public boolean updateUser(Utilisateur user){
        conn = TheConnection.getInstance();
        DAO<Organisateur> organisateurDAO = new OrganisateurDAO(conn);
        boolean res = organisateurDAO.update((Organisateur) user);
        Tools.connClose(conn);

        return res;
    }

    public ArrayList<Utilisateur> getListOfUser(){
        
        conn = TheConnection.getInstance();
        DAO<Organisateur> organisateurDAO = new OrganisateurDAO(conn);
        ArrayList<Organisateur> list =  ((OrganisateurDAO) organisateurDAO).listOrganisateur();
        
        ArrayList<Utilisateur> users = cast(list);
        Tools.connClose(conn);
        return users;
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayList<Utilisateur> cast(ArrayList<T> list) {
        return (ArrayList<Utilisateur>) list;
    }
}
