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
 import java.util.LinkedHashSet;
  import java.util.Set;
 
 import com.fasterxml.jackson.databind.node.*;
 
 public class Image extends Controller{
     public static Result get(Long pid) {
        Long p;
        byte[] image = null;
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.bilder WHERE pid = '" + pid + "'";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    p = rs.getLong("pid");
    		    image = rs.getBytes("bildercol");
    		    //thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        //byte[] image = YourService.getLogo();
        return ok(image).as("image/jpeg");
     }
    
 }