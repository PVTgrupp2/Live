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

 
 class All extends Controller{
     public static Result getAll() {
        
        
        ArrayList<BeerItem> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer";
            ResultSet rs = stmt.executeQuery(sql);	
            
            BeerItem j = new BeerItem();
    		j.id = "0";
    		j.name = "Egentligen alla listan";
    	    thelist.add(j);
                
    		while(rs.next()){
    		    
    		    BeerItem i = new BeerItem();
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
     
 }