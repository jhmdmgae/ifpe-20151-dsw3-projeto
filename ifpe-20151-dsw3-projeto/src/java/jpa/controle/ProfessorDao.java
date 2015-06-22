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
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    private final List<Professor> ProfessorList = new ArrayList<Professor>();

    public Professor getProfessor(long idProfessor) {

        try {
            Professor professor = (Professor) em.createQuery("SELECT p from Professor p where p.id = :id ").setParameter("id", idProfessor).getSingleResult();

            return professor;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirProfessor(Professor professor) {
        
        System.out.println("opa");
        try {
            
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
        }
    }
    
    public List<Professor> getProfessorList() {
        
        try {
            List<Professor> professors = em.createQuery("SELECT p from Professor p").getResultList();
            
            return professors;
        } catch (NoResultException e) {
            return null;
        }
        
    }

    public boolean deletarProfessor(Professor professor) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.remove(professor);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterarProfessor(Professor professor) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.merge(professor);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}