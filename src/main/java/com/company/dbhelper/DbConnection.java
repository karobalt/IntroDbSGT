package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // Create one static method to return the connection to the database
    // via the jdbc. It is a static method because we do not need
    // multiple connections or instances to the database.

    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://LocalHost:5432/students", "postgres", "pagalvele1");
        //    if(connection != null) System.out.println("Connection successful!");
        } catch(SQLException e){
            System.out.println("There was a problem connecting to the database");
            e.printStackTrace();
        }
        return connection;

    }
}
