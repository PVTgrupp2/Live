 package controllers;
 
 import java.sql.*;
 import java.util.ArrayList;
 
 import views.html.*;
 
 import play.*;
 import play.mvc.*;
 import play.mvc.Controller;
 import play.mvc.Result;
 import play.mvc.Results;
 import play.libs.Json;
 
 import com.fasterxml.jackson.databind.node.*;

 
public  class UtstallareController extends Controller{
         public static Result getAll() {
        ArrayList<Utstallare> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.1Utställare";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Utstallare u = new Utstallare();
    		    u.id = rs.getString("idUtställare");
    		    u.namn = rs.getString("Namn");
    		    u.land = rs.getString("Land");
    		    
    		    thelist.add(u);
    		}
    		
        }catch(Exception e){
		    //resultJson.put("Error","Dbconn");
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
           return internalServerError("List is empty");
        
        }else{
            return ok(utstlist.render(thelist));
        }
    }
      public static Result get(Long id){
        Utstallare u = new Utstallare();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM nian8516.1Utställare WHERE idUtställare=" + id;
            ResultSet rs = stmt.executeQuery(sql);	
            while(rs.next()){
                //Produkt p = new Produkt();
    		    u.id = rs.getString("idUtställare");
    		    u.namn = rs.getString("Namn");
    		    u.land = rs.getString("Land");
    		  
            }
        }catch(Exception e){
		    u.namn = e.toString();
        }
        
        //TODO more controlls?
        if(u == null){
            return internalServerError("Oops: the drink is on the table");
        }else if(false){ //FIX later
            return notFound("Out looking for a nonexistant drink I see");
        }else{
            return ok(utst.render(u));
        }
        
    }
    
     
 }