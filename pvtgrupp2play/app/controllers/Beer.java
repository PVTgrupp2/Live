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

 
 class Beer extends Controller{
 /**
    public static Result getAll() {
        //ObjectNode resultJson = Json.newObject();
        
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer";
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    //resultJson.put(rs.getString(1),rs.getString(2));
    		    Produkt i = new BeerItem();
    		    i.id = rs.getString("idBeer");
    		    i.namn = rs.getString("beerName");
    		    thelist.add(i);
    		}
    		
        }catch(Exception e){
		    //resultJson.put("Error","Dbconn");
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
           return internalServerError("Oops: the beers is on the table");
        
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result getToplist() {
        //ObjectNode resultJson = Json.newObject();
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Toplist";
            ResultSet rs = stmt.executeQuery(sql);	
            //beer name , id, totalscore
    		while(rs.next()){
    		    Produkt i = new BeerItem();
    		    i.id = rs.getString("id");
    		    i.name = rs.getString("beername");
    		    if(rs.getString("TotalScore").length() > 0){
    		        i.score = rs.getString("TotalScore");
    		        thelist.add(i);
    		    }
    		  }
    		
    		
        }catch(Exception e){
		   //i.name = e.toString();
        }
        
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the best beers is on the table");
            //return status(500, "Oops: the best beers is on the table");
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result beer(Long id){
        Produkt i = new BeerItem();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer WHERE idBeer=" + id;
            ResultSet rs = stmt.executeQuery(sql);	
            while(rs.next()){
            	i.id = rs.getString("idBeer");
            	i.name = rs.getString("beerName");
            }
        }catch(Exception e){
		    i.name = e.toString();
        }
        
        //TODO more controlls?
        if(i == null){
            return internalServerError("Oops: the beer is on the table");
        }else if(false){ //FIX later
            return notFound("Out looking for nonexistant beer I see");
        }else{
            return ok(drink.render(i));
        }
        
    }
    
    
    **/
 }