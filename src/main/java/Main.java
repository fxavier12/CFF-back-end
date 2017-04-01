import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

  public static void main(String[] args) {
      
     //define a porta do heroku
    port(Integer.valueOf(System.getenv("PORT")));
    //files
    staticFileLocation("/public");

    //get hello localhost:5000/hello 
    get("/hello", (req, res) -> "Hello World");

    //index page
    get("/", (request, response) -> {
        Map<String, Object> attributes = new HashMap<>();
        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
   
  }

}
