package readwriter;

import entity.Route;
import entity.Solution;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * DB Manager class
 * @version 1.0
 * @author Adam Szaraniec
 */

public class DBManager {
    
    private  EntityManagerFactory emf;
    private  EntityManager em;
    private  EntityTransaction et;
    
    /**
     * Constructro, call initialize method
     */
    public DBManager(){
        this.initialize();
    }
    
    
    /**
     * Initialize class
     */
     void initialize() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("SEPU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
    public void create(Solution object) throws Exception {
        et.begin();
        em.persist(object);
        et.commit();

    }
    public void save(Solution object) {
        
        et.begin();
        em.merge(object);
        et.commit();
    }
    
    
    public EntityManager getEm() {
        return em;
    }
    
    public void delete(Solution obj) {
        et.begin();
        em.remove(em.merge(obj));
        et.commit();
    }

    
    public List findAll(String query, Class objClass) {
        return em.createNamedQuery(query, objClass).getResultList();
    }

    
    public Object find(Class objClass, int id) throws Exception {
        Object obj = em.find(objClass, id);
        if (obj == null) {
            throw new Exception("invalid ID");
        }
        
        return obj;
    }
}
