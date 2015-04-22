package controllers;


import play.*;
import play.mvc.*;

import java.lang.Exception;
import java.sql.*;
import java.sql.DriverManager;

import views.html.*;
import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;
import play.libs.Json;
import play.libs.Json.*;
//import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.*;
//import com.fasterxml.jackson.databind.node.ObjectNode;


public class Application extends Controller {

    public static Result index() {

		Connection conn = null;
		Statement stmt = null;
		String result = "";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql.dsv.su.se/nian8516", "nian8516", "ozaezithaibe");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Fred_Test";
            ResultSet rs = stmt.executeQuery(sql);			
			while(rs.next()){
				result = result + rs.getString(1) + rs.getString(2) + rs.getString(3) + "<br>";
			}
        }catch(Exception e){
            return ok(index.render(e.toString()));
        }
        
        return ok(index.render("Your new application is ready.<br>" + result));
    }

    public static Result helloWeb(){
        com.fasterxml.jackson.databind.node.ObjectNode result = Json.newObject();
        result.put("content","Hello Web");
        return ok(result);
    }

    public static Result hello(){
        com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest("Expecting Json data");
        }else{
            String name = json.findPath("name").textValue();
            if(name == null){
                return badRequest("Missing parameter [name]");
            }else{
                return ok("Hej " + name);
            }
        }
    }



}
