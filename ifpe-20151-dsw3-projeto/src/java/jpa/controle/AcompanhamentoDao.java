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
import jpa.entidades.Professor;
import jpa.entidades.TCC;

public class AcompanhamentoDao  implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    private final List<Acompanhamento> AcompanhamentoList = new ArrayList<Acompanhamento>();

    public Acompanhamento getAcompanhamento(long idAcompanhamento) {
        try {
            Acompanhamento acompanhamento = (Acompanhamento) em.createQuery("SELECT a from Acompanhamento a where a.id = :id ")
                    .setParameter("id", idAcompanhamento)
                    .getSingleResult();
            return acompanhamento;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirAcompanhamento(Acompanhamento acompanhamento) {
        try {
            et = em.getTransaction();
            et.begin();
            TCC tcc = new TCC();
            tcc = acompanhamento.getTcc();
            acompanhamento.setTcc(tcc);
            em.persist(acompanhamento);
            et.commit();
            System.out.println("persistiu");
            return true;
        } catch (Exception e) {
            System.out.println("n persistiu");
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Acompanhamento> getAcompanhamentoList() {
        try {
            List<Acompanhamento> acompanhamentos = em.createQuery("SELECT a from Acompanhamento a").getResultList();
            return acompanhamentos;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Acompanhamento> getAcompanhamentoList(TCC tcc) {
        try {
            System.out.println("----OPA-----tcc id = "+tcc.getId());
            List<Acompanhamento> acompanhamentos = em.createQuery("SELECT a from Acompanhamento a where a.tcc.id = :tcc")
                    .setParameter("tcc", tcc.getId())
                    .getResultList();
            return acompanhamentos;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletarAcompanhamento(Acompanhamento acompanhamento) {
        try {
            et = em.getTransaction();
            et.begin();
            em.remove(acompanhamento);
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterarAcompanhamento(Acompanhamento acompanhamento) {
        try {
            et = em.getTransaction();
            et.begin();
            em.merge(acompanhamento);
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}