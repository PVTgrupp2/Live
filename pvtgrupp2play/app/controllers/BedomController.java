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
 
 import play.mvc.Http.MultipartFormData;
 import play.mvc.Http.MultipartFormData.FilePart;
 import java.io.File;
 
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
            String beska = dynamicForm.get("Beska");//json.findPath("beska").textValue();
            String fyllighet = dynamicForm.get("Fyllighet");//json.findPath("fyllighet").textValue();
            String sötma = dynamicForm.get("Sötma");//json.findPath("sötma").textValue();
            //String token = dynamicForm.get("pid");//json.findPath("token").textValue();

            
            
            if(false){//(Validator.validateUid(uid) && Validator.validatePid(pid) && token == null &&fyllighet==null && sötma == null && beska == null ){
                //result.put("status", "Missing parameter");
                return internalServerError("Missing parameter");
            }else{
                if(true){ //if(FBvalidator.validateFb(token)){
                    try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String score = "";
                        
                        String sql = "INSERT INTO `nian8516`.`Användare_Egenskap` (`idAnvändare`,`pid`,`Beska`,`Sötma`,`Fyllighet`)"+
                                                                            "VALUES('" + uid +"','" + pid +"','" + beska + "','" + sötma + "','" + fyllighet + "')";
                        
                        /*String sql = "INSERT INTO nian8516.Användare_Egenskap (idAnvändare_Egenskap, Användare_Egenskapcol) VALUES('"+ pid +"','" + uid +"','" + score + "')" +
                         "ON DUPLICATE KEY UPDATE idAnvändare='" + uid + "', Produkt_IdProdukt='" + pid + "', betyg='" + score + "' ";*/
                        stmt.executeUpdate(sql);
                        
                    }catch(Exception e){
                        return internalServerError("Oops: Database Error" + e.toString());
                    }
                        
                    //return ok(result);
                    
                }else{
                    //result.put("status", "Login fail");
                    return internalServerError("Oops: Login Fail");
                }
            }
        
        return redirect("https://pvt.dsv.su.se/Group2/web/allinone.html");
    }
    
    public static Result bild() {
            MultipartFormData body = request().body().asMultipartFormData();
            FilePart picture = body.getFile("picture");
              if (picture != null) {
                String fileName = picture.getFilename();
                String contentType = picture.getContentType(); 
                File file = picture.getFile();
                //return ok("File uploaded");
              } else {
                flash("error", "Missing file");
                return internalServerError("Oops: Fail");   
              }
              try{
                        Connection conn = DatabaseConn.getConn();
            		    Statement stmt = null;
                        stmt = conn.createStatement();
                        String sql2 = "INSERT INTO `nian8516`.`bilder` (`pid`,`bildercol`) VALUES('" + "1" +"','" + picture + "')";
                        stmt.executeUpdate(sql2);
                }catch(Exception e){
                    return internalServerError("Oops: Database Error" + e.toString());
                }
        return ok("File uploaded");
}
     
 }