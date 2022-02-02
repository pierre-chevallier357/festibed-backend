package com.example.api_festival;

import java.sql.Connection;
import java.util.ArrayList;

import com.example.DAO.DAO;
import com.example.DAO.FestivalDAO;
import com.example.bdConnection.TheConnection;

public class AppRequestFestival implements AppInterfaceFestival{

    
    static Connection conn;

    @Override
    public int createFestival(Festival festival) {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);
        festivalDAO.create(festival);
        festival = ((FestivalDAO) festivalDAO).readIdByName(festival);
        return festival.getIdFestival();                
    }

    @Override
    public Festival getFestival(int id) {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);
        return festivalDAO.read(id);
    }

    @Override
    public boolean updateFestival(Festival festival) {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);
        return festivalDAO.update(festival);
    }

    @Override
    public ArrayList<Festival> getListOfFestival(String nom, String ville, String type, String departement, String mois) {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);       
        ArrayList<Festival> list = ((FestivalDAO) festivalDAO).searchFestivals( nom, ville,  type,  departement, mois);            
        return list;
    }

    @Override
    public ArrayList<Festival> getListOfHundredFestival() {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);       
        ArrayList<Festival> list = ((FestivalDAO) festivalDAO).searchHundredFestivals();            
        return list;
    }


    public Festival getFestivalById(Integer id){
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);       
        return festivalDAO.read(id);

    }
}
