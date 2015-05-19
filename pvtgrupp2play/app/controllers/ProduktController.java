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

 
 public class ProduktController extends Controller{
     public static Result getAll() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("IdProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
				String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
           return internalServerError("Oops: the drinks is on the table");
        
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result getAllBeer() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE Kategori=1";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the beers is on the table");
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result getAllWisky() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE Kategori=2";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the wisky is on the table");
        
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result getTopBeer() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE Kategori=1 ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the beers is on the table");
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result getTopWisky() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE Kategori=2 ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the beers is on the table");
        }else{
            return ok(list.render(thelist));
        }
    }
    
        public static Result getTop() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        ArrayList<Produkt> thelist = new ArrayList<>();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.Produkt_Betyg ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(thelist.isEmpty()){
            return internalServerError("Oops: the beers is on the table");
        }else{
            return ok(list.render(thelist));
        }
    }
    
    public static Result get(Long id){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        Produkt p = new Produkt();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE idProdukt= '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);	
            while(rs.next()){
                //Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    p.setBetyg(rs.getString("Betyg"));
    		  
            }
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        
        //TODO more controlls?
        if(p == null){
            return internalServerError("Oops: the drink is on the table");
        }else if(false){ //FIX later
            return notFound("Out looking for a nonexistant drink I see");
        }else{
            return ok(drink.render(p));
        }
        
    }
     
 }
 