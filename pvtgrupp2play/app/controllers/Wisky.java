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

 
 class Wisky extends Controller{
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
            
            Produkt j = new BeerItem();
    		j.id = "0";
    		j.name = "Egentligen Wisky listan";
    	    thelist.add(j);
                
    		while(rs.next()){
    		    //resultJson.put(rs.getString(1),rs.getString(2));
    		    Produkt i = new BeerItem();
    		    i.id = rs.getString("idBeer");
    		    i.name = rs.getString("beerName");
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
    
    public static Result beer(Long id){
        return internalServerError("Oops: not implemented" + id);
    }
    
    public static Result getToplist() {
         return getAll();
    }
     
     **/
 }