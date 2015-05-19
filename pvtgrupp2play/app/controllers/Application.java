package controllers;




import java.lang.Exception;

import java.sql.*;
import java.sql.DriverManager;

import views.html.*;
//import play.libs.Json;

import play.*;

import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.BodyParser;

import play.libs.Json;
//import play.libs.Json.*;

import com.fasterxml.jackson.databind.node.*;

import java.util.ArrayList;
//import org.codehaus.jackson.node.ObjectNode;
//import org.codehaus.jackson.*;
//import com.fasterxml.jackson.databind.node.ObjectNode;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    /**
    public static Result helloWeb(){
        
        return ok("list.render(thelist)");
    }**/

    /**
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
    }**/
    
    /**
    public static Result fbauth(){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        com.fasterxml.jackson.databind.JsonNode json = request().body().asJson();
        if(json == null){
            return ok("Expecting Json data");
        }else{
            return ok(json);
        }
    }
    
    public static Result all(String reqType, Long id){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        if(reqType.equals("All")){
            return ProduktController.getAll();
        }else{
            return notFound();
        }
        
    } **/
    /**
    public static Result beer(String reqType, Long id){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        if(reqType.equals("Top")){
            //return Beer.getToplist();
            return notFound();
        }else if(reqType.equals("All")){
            return ProduktController.getAllBeer();
        }else if(reqType.equals("Id")){
            return ProduktController.get(id);
        }else{
            return notFound();
        }
    } **/
    
    /**
    public static Result rate(){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        return RateController.rate();
    }**/
    
    /**
    public static Result wisky(String reqType, Long id){
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        
        if(reqType.equals("Top")){
            //return Wisky.getToplist();
            return notFound();
        }else if(reqType.equals("All")){
            return ProduktController.getAllWisky();
        }else if(reqType.equals("Id")){
           return ProduktController.get(id);
        }else{
            return notFound();
        }
    }**/
    
    
    //Allow cross orgin
    public static Result preflight(String all) {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        return ok();
    }




}
