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
 import java.util.LinkedHashSet;
  import java.util.Set;
 
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("IdProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
				String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				
				p.kategori = rs.getString("KategoriNamn");
    		    
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg WHERE Kategori=1";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				p.kategori = rs.getString("KategoriNamn");
    		    thelist.add(p);
    		}
    		Set<Produkt> s = new LinkedHashSet<Produkt>(thelist);
    		thelist = new ArrayList<>(s);
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg WHERE Kategori=2";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				p.kategori = rs.getString("KategoriNamn");
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg WHERE Kategori=1 ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				p.kategori = rs.getString("KategoriNamn");
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg WHERE Kategori=2 ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				p.kategori = rs.getString("KategoriNamn");
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
            
            String sql = "SELECT DISTINCT * FROM nian8516.Produkt_Betyg ORDER BY Betyg DESC LIMIT 15";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    			String temp = rs.getString("Betyg"); 
				//Kontroller?
				p.setBetyg(temp);
				p.kategori = rs.getString("KategoriNamn");
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
            /*String sql = "SELECT P.*, (SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Beska') AS Beska," +
            "(SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Fylligt') AS Fylligt," +
            "(SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Sött') AS Sött" +
            "FROM nian8516.Produkt_Betyg AS P WHERE P.idProdukt= '" + id + "'";*/
            
            String sql = "SELECT DISTINCT * FROM nian8516.ProdBet WHERE IdProdukt ='" + id + "'";
            //"ORDER BY Betyg DESC LIMIT 15";
            //String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE idProdukt= '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);	
            while(rs.next()){
                //Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    p.setBetyg(rs.getString("Betyg"));
    		    p.kategori = rs.getString("KategoriNamn");
    		    
    		    p.beska = rs.getInt("Beska");
    		    p.fyllighet = rs.getInt("Fylligt");
    		    p.sötma = rs.getInt("Sött");
    		    p.rökighet = rs.getInt("Rökighet");
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
        public static Result getBedomd(Long id, Long anvid){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        Produkt2 p = new Produkt2();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            /*String sql = "SELECT P.*, (SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Beska') AS Beska," +
            "(SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Fylligt') AS Fylligt," +
            "(SELECT EP.grad FROM nian8516.1Egenskap_has_Produkt AS EP WHERE EP.Produkt_IdProdukt = P.IdProdukt AND EP.Egenskap_namn = 'Sött') AS Sött" +
            "FROM nian8516.Produkt_Betyg AS P WHERE P.idProdukt= '" + id + "'";*/
            
            String sql = "SELECT PB.*, AE.idAnvändare, AE.Beska, AE.Sötma, AE.Fyllighet, PA.betyg FROM ProdBet AS PB, Användare_Egenskap AS AE, 1Produkt_has_Användare AS PA WHERE PB.IdProdukt=AE.pid AND AE.pid=PA.Produkt_IdProdukt AND AE.idAnvändare= '" +anvid+"' AND PB.IdProdukt='" +id +"'" ;
            //"ORDER BY Betyg DESC LIMIT 15";
            //String sql = "SELECT * FROM nian8516.Produkt_Betyg WHERE idProdukt= '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);	
            while(rs.next()){
                //Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    p.setBetyg(rs.getString("Betyg"));
    		    p.kategori = rs.getString("KategoriNamn");
    		    
    		    p.beska = rs.getInt("Beska");
    		    p.fyllighet = rs.getInt("Fylligt");
    		    p.sötma = rs.getInt("Sött");
    		    p.rökighet = rs.getInt("Rökighet");
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
            return ok(drink2.render(p));
        }
        
    }
     
 }
 