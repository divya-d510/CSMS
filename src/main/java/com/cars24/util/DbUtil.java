package com.cars24.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.cars24.config.DbConfig.*;
//here it contains all the common class or functions which are used by all
public class DbUtil {
    private static Connection dbconnection;// when we create a var of class type it has a value null then only we can get
    // connection if not null then it means it already has a connection
    public static Connection getConnection(){
        if(dbconnection==null){
            try {
                //DriverManager is used to get the connection (java code and database) and then close it
                dbconnection=DriverManager.getConnection(host,username,password);
                System.out.println("Connection successful!");

            } catch (SQLException e) {
                System.out.println("Error connecting to the database");
                throw new RuntimeException(e);
            }
        }

        return dbconnection;
    }
    public static void closeConnection() {
        if (dbconnection != null) {
            try {
                dbconnection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error while closing connection: " + e.getMessage());
            }
        }
    }


}