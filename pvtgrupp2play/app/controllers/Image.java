 package controllers;
 
 public class Image extends Controller{
     public static Result get(Long pid) {
        Long p;
        byte[] image;
        
        try{
		    Connection conn = DatabaseConn.getConn();
    		Statement stmt = null;
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM nian8516.bilder WHERE pid = '" + pid + "'";
            
            ResultSet rs = stmt.executeQuery(sql);	
            
    		while(rs.next()){
    		    p = rs.getLong("pid");
    		    image = rs.getBytes("bildercol");
    		    thelist.add(p);
    		}
    		conn.close();
        }catch(Exception e){
		    return internalServerError("Oops: Database Error" + e.toString());
        }
        //byte[] image = YourService.getLogo();
        return ok(image).as("image/jpeg");
     }
    
 }