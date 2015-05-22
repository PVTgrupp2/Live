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

 
 public class BedomController extends Controller{
     public static Result bedom(){
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
            String beska = json.findPath("beska").textValue();
            String fyllighet = json.findPath("fyllighet").textValue();
            String sötma = json.findPath("sötma").textValue();
            String token = json.findPath("token").textValue();
            
            if(Validator.validateUid(uid) && Validator.validatePid(pid) && token == null &&fyllighet==null && sötma == null && beska == null ){
                result.put("status", "Missing parameter");
            }else{
                if(true){ //if(FBvalidator.validateFb(token)){
                    
                    try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String score = "";
                        String sql = "INSERT INTO nian8516.Användare_Egenskap (idAnvändare_Egenskap, Användare_Egenskapcol) VALUES('"+ pid +"','" + uid +"','" + score + "')" +
                         "ON DUPLICATE KEY UPDATE idAnvändare='" + uid + "', Produkt_IdProdukt='" + pid + "', betyg='" + score + "' ";
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
     
 }