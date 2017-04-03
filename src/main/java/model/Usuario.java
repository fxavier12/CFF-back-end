package model;

import javax.persistence.*;
import org.json.simple.JSONObject;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	@Column(name = "email", nullable = false, length = 40)
	private String email;
	@Column(name = "nome", nullable = false, length = 40)
	private String nome;
	@Column(name = "senha", nullable = false, length = 16)
	private String senha;

	

	public Usuario(){

	}

	public Usuario(String nome,String email,String senha){
			this.nome = nome;
			this.email = email;
			this.senha = senha;
	}

	public String Getnome(){
		return nome;
	}

	public String Getemail(){
		return email;
	}

	public Long Getid(){
		return id;
	}

	public void Setid(long id){
		this.id = id;
	}

	public String Getsenha(){
		return senha;
	}

	public JSONObject toJSON(){
		JSONObject obj = new JSONObject();
		obj.put("id",id);
		obj.put("nome",nome);
		obj.put("email",email);

		return obj;
	}
}