package api;


import static spark.Spark.*;
import spark.*;
import org.json.simple.JSONObject;
import org.apache.commons.io.IOUtils;
import model.*;
import dao.*;

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
		get("/login",(req,res) -> 
			IOUtils.toString(Spark.class.getResourceAsStream("/login.html")));


		//Sgn Up Page 
		get("/cadastro",(req,res) -> 
			IOUtils.toString(Spark.class.getResourceAsStream("/cadastro.html")));

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
				  resposta.put("mensagem ", "o campo email deve ser informado");
				  return resposta.toJSONString();
			 }

			
			 //verificando de o parametro senha foi enviado
			 if(nome == null || nome.isEmpty()){
			 	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem ", "O campo nome deve ser informado");
				  return resposta.toJSONString();
			 }

			  //verificando de o parametro senha foi enviado
			 if(senha == null || senha.isEmpty()){
			 	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem ", "O campo senha  deve ser informado");
				  return resposta.toJSONString();
			 }

			 //verificando se ja existe usuario cadastrado com esse email

 			Usuario user ;
            UsuarioDAO userDAO = new UsuarioDAO();
            //procurando usurio com esse endereco de email
            user = userDAO.loadByEmail(email);


            if( user.Getemail() != null){
            	   //ja existe usuario cadastrado com esse email
            	  System.out.println("Bad Request from IP: "+req.ip());
				  res.status(400);//400 -> bad requested
				  JSONObject resposta = new JSONObject();
				  resposta.put("mensagem ", "O email informado ja esta em uso ");
				  return resposta.toJSONString();
            }else{
            	  //cria um novo usuario
            	  user = new Usuario(nome,email,senha);
            }


            //salvando novo usuario no banco e gerando o ID

            try{
                     userDAO.save(user);
             }catch(Exception ex){
                    System.out.println("Ocorreu um erro ao salvar");
             }
           

            return user.toJSON().toJSONString();
		
				
		});
	}
}

