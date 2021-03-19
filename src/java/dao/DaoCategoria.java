
package dao;

import entidades.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Matheus
 */
public class DaoCategoria {
    private EntityManager em;
    
     public static boolean persist(Categoria cat) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cat);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
    public static Categoria getOne(Integer pId){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");  
      EntityManager em = emf.createEntityManager();
      return em.find(Categoria.class, pId);    
    }   
    
    public static boolean excluir(Integer pId){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");  
      EntityManager em = emf.createEntityManager();
      em.remove(pId); 
      return true;
    }
    
    public static List<Categoria> getAll(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Categoria> tq = em.createQuery("select c from Categoria c", Categoria.class);
        return tq.getResultList();
    }
    
    public static boolean editar(Categoria cat){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1RESTAPIPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cat);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
}
