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

 
public  class BedomdaController extends Controller{
        public static Result getBedomda(Long id) {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        
        ArrayList <Produkt> bedomdalist = new ArrayList <>();
        
         try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT DISTINCT * FROM nian8516.ProdBet LEFT JOIN Användare_Egenskap ON IdProdukt=pid WHERE idAnvändare= " + id;
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    p.setBetyg(rs.getString("Betyg"));
    		    p.kategori = rs.getString("KategoriNamn");
    		    p.alkhalt=rs.getDouble("Alk");
    		    p.beska = rs.getInt("Beska");
    		    p.fyllighet = rs.getInt("Fylligt");
    		    p.sötma = rs.getInt("Sött");
    		    
    		    p.rökighet = rs.getInt("Rökighet");
    		    
    		    bedomdalist.add(p);
    		}
         }catch(Exception e){
		    return internalServerError("Database error" + e.toString());
        }
        
        //TODO more controlls?
        if(bedomdalist.isEmpty()){
           return internalServerError("List is empty");
        
        }else{
            return ok(listmy.render(bedomdalist));
        }
        
     }
    
     
 }