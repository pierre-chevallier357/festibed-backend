package com.example.api_etablissement;
import java.util.ArrayList;

import com.example.etablissement.*;
import com.example.other.Localisation;

public interface AppInterfaceEtablissement {

    public int createEtablissement(int idEtablissement, String classement, String nom, Localisation localisation, String numeroDeTelephone,  String email, String siteInternet, int capacite, String type, int nbLogement);

    public Etablissement getEtablissement(int id);

    public boolean updateEtablissement(Etablissement etablissement);

    public ArrayList<Etablissement> getListOfEtablissement(int idEtablissement);


}