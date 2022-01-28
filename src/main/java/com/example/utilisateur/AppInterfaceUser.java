package com.example.utilisateur;
import java.util.ArrayList;

public interface AppInterfaceUser {
    
    ArrayList<Utilisateur> listUserConnect = new ArrayList<>();
    

    public int createUser(String nom , String email);

    public Utilisateur getUser(int id);

    public boolean updateUser(Utilisateur user);

    public ArrayList<Utilisateur> getListOfUser();

    public Integer connection(String email, String password);
    
}
