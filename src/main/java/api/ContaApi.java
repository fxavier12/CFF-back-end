package api;


import static spark.Spark.*;
import spark.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.apache.commons.io.IOUtils;
import model.*;
import dao.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;  



public class ContaApi{

	public ContaApi(){
		//Casatro de contas
		post("/conta",(req,res) -> {
			//HEADER
			res.header("Access-Control-Allow-Origin", "*");
			res.type("application/json");


			//get parametros 
			String dono = req.queryParams("dono");
			String descricao = req.queryParams("descricao");
			String valor = req.queryParams("valor");
			String data = req.queryParams("data");	
			String tipo = req.queryParams("tipo");			


			//verificando se o parametro dono foi enviado
			if(dono == null || dono.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo dono deve ser informado");
				return resposta.toJSONString();
			}	


			
			//verificando se o parametro descricao foi enviado
			if(descricao == null || descricao.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo descricao deve ser informado");
				return resposta.toJSONString();
			}	


			//verificando se o parametro valor foi enviado
			if(valor == null || valor.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo valor deve ser informado");
				return resposta.toJSONString();
			}	

			//verificando se o parametro data foi enviado
			if(data == null || data.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo data deve ser informado");
				return resposta.toJSONString();
			}	
			//verificando se o parametro tipo foi enviado
			if(tipo == null || tipo.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo tipo deve ser informado");
				return resposta.toJSONString();
			}

			//todos os campos foram informados 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Conta conta = new Conta(Long.parseLong(dono),descricao,Double.parseDouble(valor),sdf.parse(data),tipo);
			ContaDAO contaDao = new ContaDAO();
			
			try{
                contaDao.save(conta);
           	}catch(Exception ex){
             	//ocorreu um erro ao cadastrar a conta
             	ex.printStackTrace();	
                System.out.println("Ocorreu um erro ao salvar");
            }
           
            return conta.toJSON().toJSONString();
						
		});

		//retorna uma lista de despesas de um usuario em determinado mes 
		post("/getreceitas",(req,res) -> {
			//HEADER
			res.header("Access-Control-Allow-Origin", "*");
			res.type("application/json");


			//get parametros 
			String usuario = req.queryParams("usuario");
			String mes = req.queryParams("mes");

			//verificando se o parametro usuario foi enviado
			if(usuario == null || usuario.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo usuario deve ser informado");
				return resposta.toJSONString();
			}

			//verificando se o parametro usuario foi enviado
			if(mes == null || mes.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo mes deve ser informado");
				return resposta.toJSONString();
			}

			ContaDAO contaDao = new ContaDAO();
			List<Conta> receitas =  contaDao.loadReceitas(Long.parseLong(usuario),Integer.parseInt(mes));
			JSONArray resposta = new JSONArray();
			

			for (Conta temp : receitas) {
				JSONObject aux = new JSONObject();
				aux = temp.toJSON();
				resposta.add(aux);
			}
			return resposta.toJSONString();

		});

		//retorna uma lista de despesas de um usuario em determinado mes 
		post("/getdespesas",(req,res) -> {
			//HEADER
			res.header("Access-Control-Allow-Origin", "*");
			res.type("application/json");


			//get parametros 
			String usuario = req.queryParams("usuario");
			String mes = req.queryParams("mes");

			//verificando se o parametro usuario foi enviado
			if(usuario == null || usuario.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo usuario deve ser informado");
				return resposta.toJSONString();
			}

			//verificando se o parametro usuario foi enviado
			if(mes == null || mes.isEmpty()){
			 	System.out.println("Bad Request from IP: "+req.ip());
				res.status(400);//400 -> bad requested
				JSONObject resposta = new JSONObject();
				resposta.put("mensagem", "o campo mes deve ser informado");
				return resposta.toJSONString();
			}

			ContaDAO contaDao = new ContaDAO();
			List<Conta> receitas =  contaDao.loadDespesas(Long.parseLong(usuario),Integer.parseInt(mes));
			JSONArray resposta = new JSONArray();
			

			for (Conta temp : receitas) {
				JSONObject aux = new JSONObject();
				aux = temp.toJSON();
				resposta.add(aux);
			}
			return resposta.toJSONString();

		});

	}
}