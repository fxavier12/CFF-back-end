/*
*
* ContaDAO 
* Data Acess Object 
* MODEL : Conta
* Utiliza o ORM Hibernate
* 
* 
*/

package dao;

import java.util.List;  
import org.hibernate.*;  
import model.Conta;
import Util.*;

public class ContaDAO{  
  
   private SessionFactory factory;  
   private Session session;

   public ContaDAO() {  
       
       
   }      
  //exclui uma conta 
   public void delete(Conta conta) throws Exception{
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();  
       session.clear();
       Transaction tx = session.beginTransaction();
       session.delete(conta);  
       tx.setTimeout(5);
       tx.commit(); 
       session.close();         
   }  
   //cria uma nova conta 
   public void save(Conta conta) throws Exception{
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();  
       session.clear();
       Transaction tx = session.beginTransaction();
       System.out.println(session.save(conta));  
       tx.setTimeout(5);
       tx.commit(); 
       session.close();         
   }  

   //busca e retorna uma conta pelo id 
    public Conta load(String id)throws Exception{  
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();  
       session.clear();
       Conta conta = new Conta();
       String sql = "SELECT * FROM Conta WHERE id = ? ";
       SQLQuery query = session.createSQLQuery(sql);
       query.addEntity(Conta.class);
       query.setString(0, id);
       List<Conta> results = query.list();
       session.close();  
        if(results.size()>0){
           return results.get(0);
        }else{
           return conta;
        }
 
   }  

   //retorna uma lista de receitas de um usuario pelo id em um determinado mes
   public List<Conta> loadReceitas(Long id , int mes){
      factory = HibernateUtil.getSessionFactory();
      session = factory.openSession();  
      session.clear();
      String sql = "SELECT * FROM Conta WHERE dono = ? AND tipo = ?";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity(Conta.class);
      query.setLong(0, id);
      query.setString(1, "receita");

      List<Conta> results = query.list();
      session.close();  
      return results;
   }

   //retorna uma lista de despesas de um usuario pelo id em um determinado mes
   public List<Conta> loadDespesas(Long id , int mes){
      factory = HibernateUtil.getSessionFactory();
      session = factory.openSession();  
      session.clear();
      String sql = "SELECT * FROM Conta WHERE dono = ? AND tipo = ?";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity(Conta.class);
      query.setLong(0, id);
      query.setString(1, "despesa");

      List<Conta> results = query.list();
      session.close();  
      return results;
   }

}  
