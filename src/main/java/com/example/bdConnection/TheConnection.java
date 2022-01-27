package com.example.bdConnection;
import java.sql.*;

public class TheConnection {


	private static final String configurationFile = "src/main/java/com/example/bdConnection/BD.properties";
	static Connection connect;

	private TheConnection() {

		try {

			// Enregistrement du driver Oracleh
			System.out.print("Loading Oracle driver... ");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("loaded");

			// Etablissement de la connection
			DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
			
			System.out.print("Connecting to the database... ");
			connect = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(), dap.getPassword());
			System.out.println("connected");

			connect.setAutoCommit(true);

			// traitement d'exception
		} catch (SQLException e) {
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());

		}

	}

	public static Connection getInstance() {

		if (connect == null) {
			new TheConnection();
			System.out.println("Instanciation de la connexion SQL !\n");
		} else {
			System.out.println("Connexion SQL existante !");

		}
		return connect;
	}

}