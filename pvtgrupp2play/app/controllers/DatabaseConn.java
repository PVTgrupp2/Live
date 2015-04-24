package controllers;

import java.sql.*;

class DatabaseConn{
    public static Connection getConn(){
        try{
            return DriverManager.getConnection("jdbc:mysql://mysql.dsv.su.se/nian8516", "nian8516", "ozaezithaibe");
        }catch(Exception e){
            return null;
        }
        
    
    }
}