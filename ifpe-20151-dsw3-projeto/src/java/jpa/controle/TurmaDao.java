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
import jpa.entidades.Turma;

public class TurmaDao implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    private final List<Turma> TurmaList = new ArrayList<Turma>();

    public Turma getTurma(long idTurma) {

        try {
            Turma turma = (Turma) em.createQuery("SELECT t from Turma t where t.id = :id ")
                    .setParameter("id", idTurma)
                    .getSingleResult();

            return turma;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirTurma(Turma turma) {
        
        System.out.println("opa");
        try {
            
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
        }
    }
    
    public List<Turma> getTurmaList() {
        try {
            
            List<Turma> turmas = em.createQuery("SELECT t from Turma t").getResultList();
            return turmas;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Aluno> getAlunosTurmaList(Turma turma) {
        try {
            List<Aluno> alunos = em.createQuery("SELECT a from Aluno a where a.turma = :turma")
                    .setParameter("turma", turma)
                    .getResultList();
            return alunos;
        } catch (NoResultException e) {
            return null;
        }
    }


    public boolean deletarTurma(Turma turma) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.remove(turma);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterarTurma(Turma turma) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.merge(turma);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
