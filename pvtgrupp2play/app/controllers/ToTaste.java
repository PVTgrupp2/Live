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
     
     public static Result setToTaste(){
        ObjectNode result = Json.newObject();
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
         
        com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();
        if(json == null){
            result.put("status", "Expecting Json data");
        }else{
            String uid = json.findPath("uid").textValue();
            String pid = json.findPath("pid").textValue();
            //String score = json.findPath("score").textValue();
            String token = json.findPath("token").textValue();
            
            if(uid.length() != 18 && pid.length() != 5 && token == null){
                result.put("status", "Missing parameter");
            }else{
                if(true){ //if(FBvalidator.validateFb(token)){
                    
                    try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO nian8516.1ToTaste (1idanv, idprodukt) VALUES('"+ uid +"','" + pid + "')" +
                         "ON DUPLICATE KEY UPDATE 1idanv='" + uid + "', idprodukt='" + pid + "'";
                        stmt.executeUpdate(sql);	
                    }catch(Exception e){
                        result.put("status", e.toString());
                    }
                        
                    //return ok(result);
                    
                }else{
                    result.put("status", "Login fail");
                }
            }
        }
        return ok(result);
    }
     
     
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
            
            String sql = "SELECT * FROM nian8516.1Produkt AS PR RIGHT JOIN 1ToTaste TT ON TT.idprodukt = PR.IdProdukt WHERE 1idanv = " + id;
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    Produkt p = new Produkt();
    		    p.id = rs.getLong("idProdukt");
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
     
     
       public static Result get(Long id, Long anvid){
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
            
            String sql = "DELETE  FROM nian8516.1ToTaste WHERE IdProdukt ='" + id + "' AND 1idanv= '" +anvid +"'";
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
    		    p.alkhalt=rs.getDouble("Alkoholhalt");
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
     
 }