import static spark.Spark.*;
/*
 * LoginApi
 * Responsavel por controlar o acesso a aplicacao
 * Francisco da Cruz Xavier
 * 02/04/2017
 *
 * Para testar o metodo POST use o 
 * Plugin POSTMAN do Google-Chrome
 *
 */

public class LoginApi{
	public LoginApi(){
	
		post("/login",(req,res) -> {
			//para pegar os parametros por POST req.queryParams("nomedoparametro")
			System.out.println("parametros: "+req.queryParams());
			return "login solicitado";
		});
	}
}

