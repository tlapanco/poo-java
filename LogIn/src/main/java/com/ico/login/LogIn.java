/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.ico.login;

import java.sql.Connection;
import main.java.com.ico.login.dbconnect.Connect;

/**
 *
 * @author Admin
 */
public class LogIn {
    public static void main(String[] args){
        Connection dbConnection = Connect.getConnection();
        if(dbConnection != null){
            LogInForm mainWindow = new LogInForm(dbConnection);
            mainWindow.setVisible(true);
        }
    }
}
