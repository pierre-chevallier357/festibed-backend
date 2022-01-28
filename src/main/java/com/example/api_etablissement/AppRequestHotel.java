package com.example.api_etablissement;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.EtablissementDAO;
import com.example.bdConnection.TheConnection;
import com.example.etablissement.Etablissement;
import com.example.other.Localisation;

public class AppRequestHotel implements AppInterfaceEtablissement{
    static Connection conn;

    @Override
    public int createEtablissement(int idEtablissement, String classement, String nom, Localisation localisation,
            String numeroDeTelephone, String email, String siteInternet, int capacite, String type, int nbLogement) {
        conn = TheConnection.getInstance();
        DAO<Etablissement> etablissementDAO = new EtablissementDAO(conn);
        Etablissement etablissement = new Etablissement();
        int id = -1;
        etablissement.setClassement(classement);
        etablissement.setNomCommercial(nom);
        etablissement.setLocalisation(localisation);
        etablissement.setNumeroDeTelephone(numeroDeTelephone);
        etablissement.setEmail(email);
        etablissement.setSiteInternet(siteInternet);
        etablissement.setCapaciteDAccueil(capacite);
        etablissement.setType(type);
        etablissement.setNbLogement(nbLogement);
        if (etablissementDAO.create(etablissement)) {

            id = ((EtablissementDAO) etablissementDAO).getIdEtablissement(email);

            etablissement.setIDEtab(id);
            listEtablissementConnect.add(etablissement);

        }
        return id;
    }

    @Override
    public Etablissement getEtablissement(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateEtablissement(Etablissement etablissement) {
        conn = TheConnection.getInstance();
        DAO<Etablissement> festivalierDAO = new EtablissementDAO(conn);
        boolean res = festivalierDAO.update((Etablissement) etablissement); 
        return res;
    }

    @Override
    public ArrayList<Etablissement> getListOfEtablissement() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
