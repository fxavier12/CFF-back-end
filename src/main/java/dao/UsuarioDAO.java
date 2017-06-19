/*
*
* UsuarioDAO 
* Data Acess Object 
* MODEL : Usuario
* Utiliza o ORM Hibernate
* 
* 
*/

package dao;

import java.util.List;  
import org.hibernate.*;  
import model.Usuario;
import Util.*;

public class UsuarioDAO{  
  
   private SessionFactory factory;  
   private Session session;

   public UsuarioDAO() {  
       
       
   }       
  
   //cria um novo usuario 
   public void save(Usuario user) throws Exception{
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();  
       session.clear();
       Transaction tx = session.beginTransaction();
       System.out.println(session.save(user));  
       tx.setTimeout(5);
       tx.commit(); 
       session.close();         
   }  

   //busca e retorna um usuario pelo id 
    public Usuario load(String id)throws Exception{  
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();  
       session.clear();
       Usuario user = null;
       user = (Usuario)session.load(Usuario.class,Long.parseLong(id) );
       session.close();   
       return user; 
   }  

   //busca e retorna um usuario pelo email 
   public Usuario loadByEmail(String email){
      factory = HibernateUtil.getSessionFactory();
      session = factory.openSession();  
      session.clear();

      Usuario user = new Usuario();
      String sql = "SELECT * FROM Usuario WHERE email = ? ";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity(Usuario.class);
      query.setString(0, email);
      List<Usuario> results = query.list();
       session.close();  
      if(results.size()>0){
         return results.get(0);
      }else{
         return user;
      }

      
   }
}  
