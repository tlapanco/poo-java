/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.ico.login.user;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class User {
    private Connection dbConnection;
    private String tableName = "users";
    private String userId = "id";
    private String userNameField = "name";
    private String userPasswordField = "password";
    public static String query;
    
    public User(){
        
    }
    
    public User(Connection dbConnection){
        this.dbConnection = dbConnection;
    }
    
    public boolean addUser(String userName, String password){
        String sqlQuery = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?)",this.tableName, this.userNameField, this.userPasswordField );        
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.executeUpdate();
        }catch(Exception e){
            return false;
        }
        
        return true;
        
    }
    
    public boolean authenticateUser(String userName, String password){
        
                
        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", this.tableName, this.userNameField, this.userPasswordField);
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();
            return res.next();
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean validateUserExists(String userName){
        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = ?", this.tableName, this.userNameField);
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setString(1, userName);
            ResultSet res = ps.executeQuery();
            return res.next();
        }catch (Exception e){
            return false;
        }
        
    }
    
    public boolean updateUser(String userName,String userPass, String userId){
        String sqlQuery = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", this.tableName, this.userNameField, this.userPasswordField, this.userId);
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setString(1, userName);
            ps.setString(2, userPass);
            ps.setInt(3, Integer.parseInt(userId));
            ps.executeUpdate();
            return true;
            
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean deleteUser(String userId){
        String sqlQuery = String.format("DELETE FROM %s WHERE %s = ?", this.tableName, this.userId);
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setInt(1, Integer.parseInt(userId));
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public ArrayList<String> getUserInfo(String userName){
        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = ?", this.tableName, this.userNameField);        
        ArrayList<String> userInfo = new ArrayList<>();
        try{
            PreparedStatement ps = this.dbConnection.prepareStatement(sqlQuery);
            ps.setString(1, userName);
            ResultSet res = ps.executeQuery();
            boolean status = res.next();
            if (status) {                
                userInfo.add(res.getString(this.userNameField));
                userInfo.add(res.getString(this.userPasswordField));
                userInfo.add(String.valueOf(res.getInt(this.userId)));
                
            }
            return userInfo;
            
        }catch (Exception e){
            return userInfo;
        }
    }
    
    
    
}
