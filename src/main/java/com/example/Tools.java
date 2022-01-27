package com.example;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Tools {


    public static void connClose(Connection conn){
        
        try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
}
