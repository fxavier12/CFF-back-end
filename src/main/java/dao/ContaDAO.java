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
       Conta user = null;
       user = (Conta)session.load(Conta.class,Long.parseLong(id) );
       session.close();   
       return user; 
   }  

   //retorna uma lista de contas de um usuario pelo id
   public List<Conta> loadByUser(Long id){
      factory = HibernateUtil.getSessionFactory();
      session = factory.openSession();  
      session.clear();
      String sql = "SELECT * FROM Conta WHERE dono = ? ";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity(Conta.class);
      query.setLong(0, id);
      List<Conta> results = query.list();
      session.close();  
      return results;
   }

}  
