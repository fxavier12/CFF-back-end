import spark.*;
import java.io.File;
import static spark.Spark.*;
import org.apache.commons.io.IOUtils;
import api.*;

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
    get("/", (request, response) -> IOUtils.toString(Spark.class.getResourceAsStream("/index.html")));
   

  }
  

}
