/* 
* HibernateUtil 
* carrega o arquivo de configuracao do hibernate 
* e gerencia a sessao com o banco
*
*/

package Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // criar uma nova sessao 
            return new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            // erro ao criar a sessao 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    //retorna a sessao atual 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    //fecha a sessao atual 
    public static void shutdown() {
        getSessionFactory().close();
    }

}