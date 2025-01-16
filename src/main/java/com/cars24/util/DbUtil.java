package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection dbconnection;
    public static Connection getConnection(){

    if(dbconnection == null) {
        try {
            dbconnection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
        } catch (SQLException e) {
            System.out.println("Error Connecting to Database");
            throw new RuntimeException(e);
        }
    }
        return dbconnection;
    }
}
