package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

// will produce a connection object (Factory)
// Singleton - one instance of that object
public class ConnectionFactory {
    // What is a Connection in Java?
    private static Connection connection = null;

    // Java won't make a default constructor and we won't have access to the constructor outside of the class:
    private ConnectionFactory() {
    }


    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    private static void connect() {
        //database connection
        try {
            Properties properties = new Properties();

            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("jdbc.properties");
            properties.load(input);

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");

            Class.forName(driver);

            connection = DriverManager.getConnection(url,username,password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




//
//    // we need one public method that returns the connection:
//    public static Connection getConnection() {
//        if(connection == null) {
//            // Resource Bundle:
//            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");
//            // create the connection:
//            String url = bundle.getString("url");
//            String user = bundle.getString("username");
//            String password = bundle.getString("password");
//            try {
//                connection = DriverManager.getConnection(url, user, password);
//            } catch(SQLException exception) {
//                exception.printStackTrace();
//            }
//        }
//        // either way, we are returning the connection:
//        return connection;
//    }
}
