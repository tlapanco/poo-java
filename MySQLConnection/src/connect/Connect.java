/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class Connect {
    /*DB credentials*/
    private static final String PATH =  "jdbc:mysql://localhost:";
    private static final String PORT = "3306";
    private static final String DBNAME = "/javadbd";
    private static final String URL = PATH + PORT + DBNAME;
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    /*Public method to establish a DB connection*/
    public Connection getConnection() {
        Connection dbConnection = null;
        
        try{
            dbConnection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa...!!!");
        }/*catch (Exception e){
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        } */catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return dbConnection; //Returns Connection instance
    }
    
    
    
}
