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

 
 public class RateController extends Controller{
     public static Result rate(){
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
            String score = json.findPath("score").textValue();
            String token = json.findPath("token").textValue();
            
            if(uid.length() == 18 && pid.length() == 5 && token == null && score == null){
                result.put("status", "Missing parameter");
            }else{
                if(FBvalidator.validateFb(token)){ //if(FBvalidator.validateFb(token)){
                    
                    try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO nian8516.test (uid, pid, score) VALUES('"+ uid +"','" + pid +"','" + score + "')";
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