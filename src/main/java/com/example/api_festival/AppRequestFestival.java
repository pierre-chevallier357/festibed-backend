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
    public ArrayList<Festival> getListOfFestival(int typeOfReach, String searchElement) {
        conn = TheConnection.getInstance();
        DAO<Festival> festivalDAO = new FestivalDAO(conn);       
        ArrayList<Festival> list;
        switch (typeOfReach){

            case 1 : 
                list  = ((FestivalDAO) festivalDAO).searchFestivalsByName(searchElement);
                break;

            case 2 :
                list  = ((FestivalDAO) festivalDAO).searchFestivalsByVille(searchElement);
                break;

            case 3 :
                list  = ((FestivalDAO) festivalDAO).searchFestivalsByDepartement(searchElement);
                break;

            case 4 :
                list  = ((FestivalDAO) festivalDAO).searchFestivalsByType(searchElement);
                break;
            
            case 5 :
                list  = ((FestivalDAO) festivalDAO).searchFestivalsByTypeAndComplement(searchElement);
                break;
            case 6 :
                list  = ((FestivalDAO) festivalDAO).searchHundredFestivals();
                break;
            case 7:
                list = ((FestivalDAO) festivalDAO).searchByMonth(searchElement);
            default :
                list = new ArrayList<>();
                break;

        }
        return list;
    }

}
