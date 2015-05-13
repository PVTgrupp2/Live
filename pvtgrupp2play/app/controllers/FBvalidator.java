package controllers;

import java.io.*;
import java.util.List;
import java.net.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.restfb.DefaultFacebookClient;

public class FBvalidator {
    static String fburl = "graph.facebook.com/debug_token?";
    
    static String appid = System.getenv("FBAppID");
    static String appsecret = System.getenv("FBAppSecret");
    static String ver = "v2.3";
    
    
    
    public static boolean validateFb(String token){
        String ourToken = appid + "|" + appsecret;
        String theUrl = fburl + "input_token={" + token + "}" + " &access_token={" + ourToken + "}";
        String response = getHTML(theUrl);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = null;
        try{
            obj = mapper.readTree(response);
        }catch(IOException ioe){
            //
        }
        
        List<String> auth = obj.findValuesAsText("is_valid");
        String auths = auth.get(1);
        if(auth.equals("true")){
            return true;
        }else{
            return false;
        }
    }
    
    
   public static String getHTML(String urlToRead) {
      URL url;
      HttpURLConnection conn;
      BufferedReader rd;
      String line;
      String result = "";
      try {
         url = new URL(urlToRead);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((line = rd.readLine()) != null) {
            result += line;
         }
         rd.close();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return result;
   }

  /** public static void main(String args[])
   {
     c c = new c();
     System.out.println(c.getHTML(args[0]));
   } **/
   
   

}