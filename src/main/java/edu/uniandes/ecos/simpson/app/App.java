package edu.uniandes.ecos.simpson.app;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
    	get("/", (req, res) -> {
    		
    		Map<String, Object> attributes = new HashMap<>();
            attributes.put("resultRanges", "");
            return new ModelAndView(attributes, "index.ftl");
            
    	},new FreeMarkerEngine());
    }
}
