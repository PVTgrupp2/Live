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
 
 import static play.data.Form.form;
 import play.data.DynamicForm;
 
 import com.fasterxml.jackson.databind.node.*;

 
 public class BedomController extends Controller{
     public static Result bedom(){
        ObjectNode result = Json.newObject();
        
        DynamicForm dynamicForm = form().bindFromRequest();
        
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
         
        //com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();

            String uid = dynamicForm.get("uid");//json.findPath("uid").textValue();
            String pid = dynamicForm.get("pid");//json.findPath("pid").textValue();
            String beska = "1";//json.findPath("beska").textValue();
            String fyllighet = "1";//json.findPath("fyllighet").textValue();
            String sötma = "1";//json.findPath("sötma").textValue();
            String token = "1";//json.findPath("token").textValue();
            
            if(false){//(Validator.validateUid(uid) && Validator.validatePid(pid) && token == null &&fyllighet==null && sötma == null && beska == null ){
                result.put("status", "Missing parameter");
            }else{
                if(true){ //if(FBvalidator.validateFb(token)){
                    
                    try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String score = "";
                        
                        String sql = "INSERT INTO `nian8516`.`Användare_Egenskap` (`idAnvändare_Egenskap`,`Användare_Egenskapcol`,`pid`,`grad`,`Beska`,`Sötma`,`Fyllighet`)"+
                                                                            "VALUES('" + "1" +"','" + "2" + "','" + "','" + pid +"','" + beska + "','" + sötma + "','" + fyllighet + "')";
                        /*String sql = "INSERT INTO nian8516.Användare_Egenskap (idAnvändare_Egenskap, Användare_Egenskapcol) VALUES('"+ pid +"','" + uid +"','" + score + "')" +
                         "ON DUPLICATE KEY UPDATE idAnvändare='" + uid + "', Produkt_IdProdukt='" + pid + "', betyg='" + score + "' ";*/
                        stmt.executeUpdate(sql);	
                    }catch(Exception e){
                        result.put("status", e.toString());
                    }
                        
                    //return ok(result);
                    
                }else{
                    result.put("status", "Login fail");
                }
            }
        
        return ok(result);
    }
     
 }