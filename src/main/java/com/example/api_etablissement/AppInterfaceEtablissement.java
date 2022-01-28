package com.example.api_etablissement;
import java.util.ArrayList;

import com.example.etablissement.*;

public interface AppInterfaceEtablissement {

    public int createEtablissement(Etablissement etablissement);

    public Etablissement getEtablissement(Integer id);

    public boolean updateEtablissement(Etablissement etablissement);

    public ArrayList<Etablissement> getListOfEtablissement(Integer idFestival, String type, int typeOfReach, String option);


}