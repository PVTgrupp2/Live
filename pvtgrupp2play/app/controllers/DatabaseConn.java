package controllers;

import java.sql.*;

class DatabaseConn{
    public static Connection getConn() throws Exception{
        String pass = System.getenv("DBpass");
        return DriverManager.getConnection("jdbc:mysql://mysql.dsv.su.se/nian8516", "nian8516", pass);
    }
}