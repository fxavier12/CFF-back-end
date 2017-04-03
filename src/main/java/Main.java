import java.util.HashMap;
import java.util.Map;
import spark.*;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

  public static void main(String[] args) {
      
     //define a porta do heroku
    port(Integer.valueOf(System.getenv("PORT")));
    //files
    staticFileLocation("/public");

    //rota de login
    LoginApi login = new LoginApi();
    //get hello localhost:5000/hello 
    get("/hello", (req, res) -> "Hello World");

    //index page
    get("/", (request, response) -> {
	Map<String, Object> attributes = new HashMap<>();
        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());
   
  }

}
