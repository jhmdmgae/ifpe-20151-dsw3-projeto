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
import jpa.entidades.Acompanhamento;
import jpa.entidades.Aluno;
import jpa.entidades.Professor;
import jpa.entidades.TCC;
import jsf.AcompanhamentoMB;

public class AlunoDao implements Serializable {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;

    private final List<Aluno> AlunoList = new ArrayList<Aluno>();

    public Aluno getAluno(long idAluno) {
        try {
            Aluno aluno = (Aluno) em.createQuery("SELECT p from Aluno p where p.id = :id ")
                    .setParameter("id", idAluno)
                    .getSingleResult();
            return aluno;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirAluno(Aluno aluno) {
        try {
            et = em.getTransaction();
            et.begin();
            Professor professor = new Professor();
            professor = aluno.getOrientador();
            aluno.setOrientador(professor);
            em.persist(aluno);
            et.commit();
            System.out.println("persistiu");
            return true;
        } catch (Exception e) {
            System.out.println("n persistiu");
            e.printStackTrace();
            return false;
        }
    }

    public List<Aluno> getAlunoList() {
        try {
            List<Aluno> alunos = em.createQuery("SELECT a from Aluno a").getResultList();
            return alunos;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean deletarAluno(Aluno aluno) {
        try {
            et = em.getTransaction();
            et.begin();
            if (aluno.getTcc()!=null) {
                TCC tcc = aluno.getTcc();
                
                AcompanhamentoMB acomp = new AcompanhamentoMB();
                List<Acompanhamento> acompanhamentoList = acomp.getAcompanhamentoList(tcc);
                if (acompanhamentoList.size() != 0) {
                    for (Acompanhamento acompanhamento : acompanhamentoList) {
                        acomp.remove(acompanhamento);
                    }
                }
                em.merge(tcc);
                em.remove(tcc);
            }
            em.remove(aluno);
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarAluno(Aluno aluno) {
        try {
            et = em.getTransaction();
            et.begin();
            em.merge(aluno);
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
