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
import jpa.entidades.Professor;

public class ProfessorDao  implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
//    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    private final List<Professor> ProfessorList = new ArrayList<Professor>();

    public Professor getProfessor(long idProfessor) {

        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            Professor professor = (Professor) em.createQuery("SELECT p from Professor p where p.id = :id ").setParameter("id", idProfessor).getSingleResult();

            return professor;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean inserirProfessor(Professor professor) {
        
        EntityManager em = null;
        
        System.out.println("opa");
        try {
            
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(professor);
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
    
    public List<Professor> getProfessorList() {
        
        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            List<Professor> professors = em.createQuery("SELECT a from Professor a").getResultList();
            
            for (Professor professor : professors) {
                
                System.out.println("id = "+professor.getId());
                System.out.println("nome = "+professor.getNome());
                
            }
            
            return professors;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    public boolean deletarProfessor(Professor professor) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.remove(professor);
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
    
    public boolean alterarProfessor(Professor professor) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(professor);
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