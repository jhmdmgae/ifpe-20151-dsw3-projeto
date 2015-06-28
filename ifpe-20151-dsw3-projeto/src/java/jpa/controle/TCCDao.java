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
import jpa.entidades.AreaConhecimento;

public class TCCDao implements Serializable{

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
            
            System.out.println("aluno = "+tcc.getAluno());
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
    
    public List<AreaConhecimento> getGrandeAreaList() {
        try {
            List<AreaConhecimento> areas = em.createQuery("SELECT a from AreaConhecimento a where a.area = 0").getResultList();
            return areas;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AreaConhecimento> getAreaList(int grandeArea) {
        try {
            List<AreaConhecimento> areas = em.createQuery("SELECT a from AreaConhecimento a where a.grandeArea = :grandeArea and a.area != 0 and a.subArea = 0")
                    .setParameter("grandeArea", grandeArea).getResultList();
            return areas;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AreaConhecimento> getSubAreaList(int grandeArea, int area) {
        try {
            List<AreaConhecimento> areas = em.createQuery("SELECT a from AreaConhecimento a where a.grandeArea = :grandeArea and a.area = :area and a.subArea != 0 and a.areaEspecifica = 0")
                    .setParameter("grandeArea", grandeArea)
                    .setParameter("area", area)
                    .getResultList();
            return areas;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AreaConhecimento> getAreaEspList(int grandeArea, int area, int subarea) {
        try {
            List<AreaConhecimento> areas = em.createQuery("SELECT a from AreaConhecimento a where a.grandeArea = :grandeArea and a.area = :area and a.subArea = :subArea and a.areaEspecifica != 0")
                    .setParameter("grandeArea", grandeArea)
                    .setParameter("area", area)
                    .setParameter("subArea", subarea)
                    .getResultList();
            return areas;
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
    
    public boolean alterarTCC(TCC tcc) {
        try {
            
            et = em.getTransaction();
            et.begin();
            em.merge(tcc);
            et.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}