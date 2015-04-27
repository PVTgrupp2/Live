 package controllers;
 
 import java.sql.*;
 
 import play.*;
 import play.mvc.*;
 import play.mvc.Controller;
 import play.mvc.Result;
 import play.mvc.Results;
 import play.libs.Json;
 
 import com.fasterxml.jackson.databind.node.*;
 
 
 class Beer extends Controller{
 
    public static Result getAll() {
        ObjectNode resultJson = Json.newObject();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer";
            ResultSet rs = stmt.executeQuery(sql);	
                
    		while(rs.next()){
    		    resultJson.put(rs.getString(1),rs.getString(2));
    		}
    		
    		
    		
        }catch(Exception e){
		    resultJson.put("Error","Dbconn");
        }
        
        //TODO more controlls?
        if(resultJson == null){
           return internalServerError("Oops: the beers is on the table");
        
        }else{
            return ok(resultJson);
        }
    }
    
    public static Result getToplist() {
        ObjectNode resultJson = Json.newObject();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Toplist";
            ResultSet rs = stmt.executeQuery(sql);	
            //beer name , id, totalscore
    		    while(rs.next()){
        		    //resultJson.put("id",rs.getString("Id"));
        		    resultJson.put("name",rs.getString("beerName"));
        		   // resultJson.put("totalscore",rs.getString("TotalScore"));
    		   }
    		
    		
        }catch(Exception e){
		    resultJson.put("Error","Dbconn");
        }
        
        
        //TODO more controlls?
        if(resultJson == null){
            return internalServerError("Oops: the best beers is on the table");
            //return status(500, "Oops: the best beers is on the table");
        }else{
            return ok(resultJson);
        }
    }
    
    public static Result beer(Long id){
        ObjectNode resultJson = Json.newObject();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer WHERE idBeer=" + id;
            ResultSet rs = stmt.executeQuery(sql);	

        		while(rs.next()){
        		    resultJson.put(rs.getString(1),rs.getString(2));
        		}
           
    		
        }catch(Exception e){
		    resultJson = null;
        }
        
        //TODO more controlls?
        if(resultJson == null){
            return internalServerError("Oops: the beer is on the table");
        }else if(resultJson.size() < 1){
            return notFound("Out looking for nonexistant beer I see");
        }else{
            return ok(resultJson);
        }
        
    }
    
    
    
 }