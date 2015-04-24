 package controllers;
 
 import java.sql.*;
 import play.*;
 import play.mvc.*;
 import com.fasterxml.jackson.databind.node.*;
 import play.libs.Json;
 
 class Beer{
 
    public static ObjectNode getAll() {

		Connection conn = DatabaseConn.getConn();
		Statement stmt = null;
		
		ObjectNode resultJson = Json.newObject();
		
		
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Beer";
            ResultSet rs = stmt.executeQuery(sql);	
            
			while(rs.next()){
			    resultJson.put(rs.getString(1),rs.getString(2));
			}
			return resultJson;
        }catch(Exception e){
            
            return null;
        }
        
        
    }
    
    public static ObjectNode getAllTest() {
		ObjectNode resultJson = Json.newObject();
		resultJson.put("1","Carlsberg");
		resultJson.put("2","Falcon");
		resultJson.put("3","Sofiero");
		resultJson.put("4","Pripps blå");
		
		
		return resultJson;
        
        
        
    }
    
 }