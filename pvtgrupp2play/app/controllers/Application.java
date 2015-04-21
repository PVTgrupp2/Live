package controllers;

import jdk.nashorn.internal.ir.ObjectNode;
import play.*;
import play.mvc.*;

import java.lang.Exception;
import java.sql.*;
import java.sql.DriverManager;

import views.html.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

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
        ObjectNode result = Json.newObject();
        result.put("content","Hello Web");
        return ok(result);
    }

}
