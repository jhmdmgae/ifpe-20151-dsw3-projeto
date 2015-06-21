package jpa.controle;

/**
 *
 * @author João Henrique 2
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import jpa.entidades.TCC;

public class TCCDao {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    private final List<TCC> TCCList = new ArrayList<TCC>();

    public TCC getTCC(long idTCC) {

        try {
            TCC tcc = (TCC) em.createQuery("SELECT t from TCC t where t.id = :id ").setParameter("id", idTCC).getSingleResult();

            return tcc;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirTCC(TCC tcc) {
        
        System.out.println("opa");
        try {
            
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
        }
    }
    
    public List<TCC> getTCCList() {
        
        try {
            List<TCC> tccs = em.createQuery("SELECT t from TCC t").getResultList();
            
            return tccs;
        } catch (NoResultException e) {
            return null;
        }
        
    }

    public boolean deletarTCC(TCC tcc) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.remove(tcc);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
