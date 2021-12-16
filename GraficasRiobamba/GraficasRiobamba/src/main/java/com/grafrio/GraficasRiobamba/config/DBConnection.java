package com.grafrio.GraficasRiobamba.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {

	private Connection dbConnection;
	 
	  public void getDBConnection() throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/portafolio", "root", "");
	  }
	 
	  public int executeQuery(String query) throws ClassNotFoundException, SQLException {
	    return dbConnection.createStatement().executeUpdate(query);
	  }

}
