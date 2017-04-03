package dao;

import java.util.List;  
import org.hibernate.*;  
import model.Usuario;
import Util.*;

public class UsuarioDAO{  
  
   private SessionFactory factory;  
   private Session session;

   public UsuarioDAO() {  
       
       factory = HibernateUtil.getSessionFactory();
       session = factory.openSession();
   }       
  
   public void save(Usuario user) throws Exception{  
         
         session.clear();
         Transaction tx = session.beginTransaction();
         System.out.println(session.save(user));  
         tx.setTimeout(5);
         tx.commit(); 
         
     
       
   }  

    public Usuario load(String id)throws Exception{  
        session.clear();
         Usuario user = null;
      
          user = (Usuario)session.load(Usuario.class,Long.parseLong(id) );
          
       
         return user; 

     
   }  

   public Usuario loadByEmail(String email){
          Usuario user = new Usuario();

          String sql = "SELECT * FROM Usuario WHERE email = ? ";
          SQLQuery query = session.createSQLQuery(sql);
          query.addEntity(Usuario.class);
          query.setString(0, email);
          List<Usuario> results = query.list();
          if(results.size()>0){
             return results.get(0);
          }else{
             return user;
          }

          
   }
      
  /* public java.util.List getList(String condicao) throws Exception{  
      Session session = factory.openSession(); 
      List amigos = session.find(condicao);  
      session.flush();  
      session.close();  
      return amigos;  
   }  
      
  
      
   public void delete(Amigo amigo) throws Exception{  
      Session session = factory.openSession();  
      session.delete(amigo);  
      session.flush();  
      session.close();  
   }  
   */
}  
