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
import jpa.entidades.AreaConhecimento;

public class AreaDao implements Serializable{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();
    private EntityTransaction et = null;
    
    private final List<AreaConhecimento> AreaConhecimentoList = new ArrayList<AreaConhecimento>();

    public AreaConhecimento getAreaConhecimento(long idAreaConhecimento) {

        try {
            AreaConhecimento areaConhecimento = (AreaConhecimento) em.createQuery("SELECT a from AreaConhecimento a where a.id = :id ").setParameter("id", idAreaConhecimento).getSingleResult();

            return areaConhecimento;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AreaConhecimento> getAreaConhecimentoList() {
        
        try {
            List<AreaConhecimento> areaConhecimentos = em.createQuery("SELECT a from AreaConhecimento a").getResultList();
            
            return areaConhecimentos;
        } catch (NoResultException e) {
            return null;
        }
        
    }

}