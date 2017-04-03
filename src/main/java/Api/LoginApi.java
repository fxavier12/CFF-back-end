import static spark.Spark.*;
import spark.*;
import org.json.simple.JSONObject;
import spark.template.freemarker.FreeMarkerEngine;
import java.util.HashMap;
import java.util.Map;

/*
 * LoginApi
 * Responsavel por Cadastrar usuarios e 
 * controlar o acesso a aplicacao
 * Formato das respostas JSON
 * Francisco da Cruz Xavier
 * 02/04/2017
 *
 * Para testar o metodo POST use o 
 * Plugin POSTMAN do Google-Chrome
 * ou acesse pelo navegador 
 * localhost:5000/login
 * localhost:5000/cadastro
 * 
 *
 */

public class LoginApi{
	public LoginApi(){
	
		post("/login",(req,res) -> {
			//para pegar os parametros por POST req.queryParams("nomedoparametro")
			System.out.println("parametros: "+req.queryParams());
			return "login solicitado";
		});

		//Login Page 
		get("/Login",(req,res) ->{
			Map<String, Object> attributes = new HashMap<>();
	        return new ModelAndView(attributes, "login.ftl");
    	}, new FreeMarkerEngine());

		//Cadastro de Usuarios 
		post("/cadastro",(req,res) -> {
			//HEADER
			res.header("Access-Control-Allow-Origin", "*");
			res.type("application/json");

			//get valores
			String email = req.queryParams("email");
			String senha = req.queryParams("senha");
			String nome = req.queryParams("nome");

			System.out.println("requisicao cadastro usuario : "+email+" | "+nome+" | "+senha);
			
			//verificando se o parametro email foi enviado
			 if(email == null || email.isEmpty()){
			 	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem :", "o campo email deve ser informado");
				  return resposta.toJSONString();
			 }

			
			 //verificando de o parametro senha foi enviado
			 if(nome == null || nome.isEmpty()){
			 	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem :", "O campo nome deve ser informado");
				  return resposta.toJSONString();
			 }

			  //verificando de o parametro senha foi enviado
			 if(senha == null || senha.isEmpty()){
			 	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem :", "O campo senha  deve ser informado");
				  return resposta.toJSONString();
			 }

			JSONObject resposta = new JSONObject();
			resposta.put("mensagem :", "Usuario criado com sucesso!");
			return resposta.toJSONString();

		
				
		});
	}
}

