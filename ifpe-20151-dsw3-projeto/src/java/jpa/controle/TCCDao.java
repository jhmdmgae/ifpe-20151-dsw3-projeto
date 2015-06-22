package jpa.controle;

/**
 *
 * @author João Henrique 2
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import jpa.entidades.TCC;

public class TCCDao  implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
//    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    private final List<TCC> TCCList = new ArrayList<TCC>();

    public TCC getTCC(long idTCC) {

        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            TCC tcc = (TCC) em.createQuery("SELECT p from TCC p where p.id = :id ").setParameter("id", idTCC).getSingleResult();

            return tcc;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean inserirTCC(TCC tcc) {
        
        EntityManager em = null;
        
        System.out.println("opa");
        try {
            
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(tcc);
            et.commit();
            
            System.out.println("persistiu");
            return true;
        } catch (Exception e) {
            System.out.println("n persistiu");
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<TCC> getTCCList() {
        
        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            List<TCC> tccs = em.createQuery("SELECT a from TCC a").getResultList();
            
            for (TCC tcc : tccs) {
                
//                System.out.println("id = "+tcc.getId());
//                System.out.println("nome = "+tcc.getNome());
                
            }
            
            return tccs;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    public boolean deletarTCC(TCC tcc) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.remove(tcc);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public boolean alterarTCC(TCC tcc) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(tcc);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}