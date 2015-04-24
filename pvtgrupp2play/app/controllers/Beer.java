 package controllers;
 
 import java.sql.*;
 import play.*;
 import play.mvc.*;
 import com.fasterxml.jackson.databind.node.*;
 import play.libs.Json;
 
 class Beer{
 
    public static ObjectNode getAll() {
        ObjectNode resultJson = Json.newObject();
        
        try{
		    Connection conn = DatabaseConn.getConn();
        
    		Statement stmt = null;
    		
            stmt = conn.createStatement();
            String sql = "SELECT * FROM beer";
            ResultSet rs = stmt.executeQuery(sql);	
                
    		while(rs.next()){
    		    resultJson.put(rs.getString(1),rs.getString(2));
    		}
    		
    		
    		
        }catch(Exception e){
		    resultJson.put("Error","Dbconn");
        }
        
        return resultJson;
    }
    
    public static ObjectNode getToplist() {
        ObjectNode resultJson = Json.newObject();
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Toplist";
            ResultSet rs = stmt.executeQuery(sql);	
                
    		while(rs.next()){
    		    resultJson.put(rs.getString(1),rs.getString(2));
    		}
    		
        }catch(Exception e){
		    resultJson.put("Error","Dbconn");
        }
        
        return resultJson;
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