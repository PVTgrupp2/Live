package controllers;


import java.lang.Exception;

import java.sql.*;
import java.sql.DriverManager;

import views.html.*;


import play.*;

import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.BodyParser;

import play.libs.Json;


import com.fasterxml.jackson.databind.node.*;

import java.util.ArrayList;



public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    
    
    //Allow cross orgin
    public static Result preflight(String all) {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Allow", "*");
        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        return ok();
    }




}
