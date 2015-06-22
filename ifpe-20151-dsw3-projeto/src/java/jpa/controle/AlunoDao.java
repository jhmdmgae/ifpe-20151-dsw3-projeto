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
import jpa.entidades.Aluno;

public class AlunoDao  implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
//    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    private final List<Aluno> AlunoList = new ArrayList<Aluno>();

    public Aluno getAluno(long idAluno) {

        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            Aluno aluno = (Aluno) em.createQuery("SELECT p from Aluno p where p.id = :id ").setParameter("id", idAluno).getSingleResult();

            return aluno;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean inserirAluno(Aluno aluno) {
        
        EntityManager em = null;
        
        System.out.println("opa");
        try {
            
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(aluno);
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
    
    public List<Aluno> getAlunoList() {
        
        EntityManager em = null;
        
        try {
            
            em = getEntityManager();
            List<Aluno> alunos = em.createQuery("SELECT a from Aluno a").getResultList();
            
            for (Aluno aluno : alunos) {
                
                System.out.println("id = "+aluno.getId());
                System.out.println("nome = "+aluno.getNome());
                
            }
            
            return alunos;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    public boolean deletarAluno(Aluno aluno) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.remove(aluno);
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
    
    public boolean alterarAluno(Aluno aluno) {
        
        EntityManager em = null;
        
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            em.merge(aluno);
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