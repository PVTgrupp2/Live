package controllers;

import play.*;
import play.mvc.*;

import java.lang.Exception;
import java.sql.*;
import java.sql.DriverManager;

import views.html.*;

public class Application extends Controller {

    public static Result index() {

		Connection conn = null;
		Statement stmt = null;
		String result = "";
        try {
            conn = DriverManager.getConnection("mysql://mysql.dsv.su.se/nian8516", "nian8516", "ozaezithaibe");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Fred_Test";
            ResultSet rs = stmt.executeQuery(sql);
        }catch(Exception e){
            return ok(index.render(e));
        }
        while(rs.next()){
            result = result + rs;
        }

        return ok(index.render("Your new application is ready." + result));
    }

}
