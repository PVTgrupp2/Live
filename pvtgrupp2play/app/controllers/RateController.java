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
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest("Expecting Json data");
        }else{
            String id = json.findPath("id").textValue();
            String data = json.findPath("data").textValue();
            String token = json.findPath("token").textValue();
            if(id == null && data == null && token == null){
                return badRequest("Missing parameter [name]");
            }else{
                if(FBvalidator.validateFb(token)){
                    try{
                        Connection conn = DatabaseConn.getConn();
        		        Statement stmt = null;
                        stmt = conn.createStatement();
                        String sql = "INSERT INTO nian8516.test (idtest, testcol) VALUES" + "("+ id +",'" + data + "')";
                        //ResultSet rs = 
                        stmt.executeUpdate(sql);	
                    }catch(Exception e){
                        return internalServerError("Oops: the drinks is on the table" + e.toString());
                    }
                    
                    return ok();
                }else{
                   return internalServerError("Login fail");
                }
                
            }
        }
    }
     
 }