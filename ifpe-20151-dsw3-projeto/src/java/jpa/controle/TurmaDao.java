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
import jpa.entidades.Turma;

public class TurmaDao  implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
//    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    private final List<Turma> TurmaList = new ArrayList<Turma>();

    public Turma getTurma(long idTurma) {

        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            Turma turma = (Turma) em.createQuery("SELECT p from Turma p where p.id = :id ").setParameter("id", idTurma).getSingleResult();

            return turma;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean inserirTurma(Turma turma) {
        
        EntityManager em = null;
        
        System.out.println("opa");
        try {
            
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(turma);
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
    
    public List<Turma> getTurmaList() {
        
        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            List<Turma> turmas = em.createQuery("SELECT a from Turma a").getResultList();
            
            for (Turma turma : turmas) {
                
//                System.out.println("id = "+turma.getId());
//                System.out.println("nome = "+turma.getNome());
                
            }
            
            return turmas;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    public boolean deletarTurma(Turma turma) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.remove(turma);
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
    
    public boolean alterarTurma(Turma turma) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(turma);
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
