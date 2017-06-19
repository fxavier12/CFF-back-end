import spark.*;
import java.io.File;
import static spark.Spark.*;
import org.apache.commons.io.IOUtils;
import api.*;

public class Main {

  public static void main(String[] args) {
      
    //define a porta do heroku
     port(Integer.valueOf(System.getenv("PORT")));
  	//port(8798);
    //files
    staticFileLocation("/public");

    //rota de login
    LoginApi login = new LoginApi();
   
  }
}
