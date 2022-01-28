package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.example.panier.Panier;

public abstract class Tools {


    public static void connClose(Connection conn){
        
        try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }


	public static Integer randomNum(){
        Random r = new Random();
		int low = 1000;
		int high = 9999;
		return  r.nextInt(high-low) + low;
    }
    



	public static Panier panierDansList(ArrayList<Panier> listPanier, Integer id ){
		Panier panier = null;
		for (Panier p : listPanier) {
			if(p.getIdPanier().equals(id)){
				panier = p;
			}
		}
		return panier;
	}

	public static Panier panierDansListIdUser(ArrayList<Panier> listPanier, Integer idUser ){
		Panier panier = null;
		for (Panier p : listPanier) {
			if(p.getIdFestivalier().equals(idUser)){
				panier = p;
			}
		}
		return panier;
	}

}