//INSERT INTO `nian8516`.`test` (`idtest`, `testcol`) VALUES ('1', 'test');

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

 
 class RateController extends Controller{
     public static Result hello(){
        com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest("Expecting Json data");
        }else{
            String id = json.findPath("id").textValue();
            String data = json.findPath("data").textValue();
            if(id == null && data == null){
                return badRequest("Missing parameter [name]");
            }else{
                try{
                    Connection conn = DatabaseConn.getConn();
    		        Statement stmt = null;
                    stmt = conn.createStatement();
                    String sql = "INSERT INTO `nian8516`.`test` (`idtest`, `testcol`) VALUES"+ "('"+ id +"', '" + data + "')";
                    ResultSet rs = stmt.executeQuery(sql);	
                }catch(Exception e){
                    return internalServerError("Oops: the drinks is on the table" + e.toString());
                }
                return ok();
            }
        }
    }
     
 }