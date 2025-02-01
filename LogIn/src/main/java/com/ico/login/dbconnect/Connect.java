/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.ico.login.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Connect {
    /*DB credentials*/
    private static final String PATH =  "jdbc:mysql://localhost:";
    private static final String PORT = "3306";
    private static final String DBNAME = "/javadb";
    private static final String URL = PATH + PORT + DBNAME;
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(URL, USER, PASS);            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos, intentelo más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
        }       
        
        return dbConnection;
    }
    
}
