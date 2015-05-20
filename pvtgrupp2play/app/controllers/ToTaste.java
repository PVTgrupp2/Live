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
     
 }