package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
		Connection conn = null;
		Statement stmt = null;
		String result = "";
		try{
			conn = DB.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Fred_Test";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				result = result + rs;
			}
		}catch(Exeption e){
			
		}
		
		
        return ok(index.render("Your new application is ready." + rs));
    }

}
