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
 
 public class ToTaste extends Controller{
     
     public static Result getToTaste(Long id) {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        
        ArrayList <Produkt> totastelist = new ArrayList <>();
        
         try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.1Produkt AS PR RIGHT JOIN 1ToTaste TT ON TT.idprodukt = PR.IdProdukt WHERE 1idanv = id" + id;
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getString("idProdukt");
    		    p.namn = rs.getString("Namn");
    		    p.land = rs.getString("Land");
    		    
    		    totastelist.add(p);
    		}
         }catch(Exception e){
		    return internalServerError("Database error" + e.toString());
        }
        
        //TODO more controlls?
        if(totastelist.isEmpty()){
           return internalServerError("List is empty");
        
        }else{
            return ok(list.render(totastelist));
        }
        
     }
     
 }