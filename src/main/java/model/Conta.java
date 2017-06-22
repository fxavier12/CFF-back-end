/*
* MODEL Usuario 
* Anatocoes para ser utilizada com o ORM  Hibernate
* 
*/

package model;

import javax.persistence.*;
import org.json.simple.JSONObject;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Conta")
public class Conta{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	@Column(name = "dono", nullable = false)
	private Long dono;
	@Column(name = "descricao", nullable = false, length = 40)
	private String descricao;
	@Column(name = "tipo", nullable = false, length = 40)
	private String tipo;
	@Column(name = "valor", nullable = false)
	private Double valor;
	@Column(name = "data", nullable = false)
	private Date data;

	public Conta(){

	}

	public Conta(Long dono,String descricao,Double valor,Date data,String tipo ){
		this.dono = dono;
		this.valor = valor;
		this.descricao = descricao;
		this.data = data;
		this.tipo = tipo;
	}



	//gets
	public Long Getdono(){
		return dono;
	}

	public String Getdescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public String Gettipo(){
		return tipo;
	}

	public Long Getid(){
		return id;
	}

	public void Setid(long id){
		this.id = id;
	}

	public Date Getdata(){
		return data;
	}

	public void setData(Date data){
		this.data = data;
	}
	public Double Getvalor(){
		return valor;
	}

	public void setValor(Double valor){
		this.valor = valor;
	}
	//sets

	//retorna a conta em formato JSON 
	public JSONObject toJSON(){
		JSONObject obj = new JSONObject();
		obj.put("id",id);
		obj.put("descricao",descricao);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		obj.put("data",sdf.format(data));
		obj.put("valor",valor);
		obj.put("dono",dono);
		obj.put("tipo",tipo);

		return obj;
	}
}