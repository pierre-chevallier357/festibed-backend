package com.example.api_etablissement;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.bdConnection.TheConnection;
import com.example.etablissement.Etablissement;
import com.example.other.Localisation;

public class AppRequestCamping implements AppInterfaceEtablissement {

    static Connection conn;

    @Override
    public int createEtablissement(int idEtablissement, String classement, String nom, Localisation localisation,
            String numeroDeTelephone, String email, String siteInternet, int capacite, String type, int nbLogement) {
        conn = TheConnection.getInstance();
        return 0;
    }

    @Override
    public Etablissement getEtablissement(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateEtablissement(Etablissement etablissement) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Etablissement> getListOfEtablissement() {
        // TODO Auto-generated method stub
        return null;
    }

}