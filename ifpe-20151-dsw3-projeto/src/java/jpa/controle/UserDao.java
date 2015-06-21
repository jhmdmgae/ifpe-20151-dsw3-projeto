package jpa.controle;

/**
 *
 * @author João Henrique 2
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import jpa.entidades.User;

public class UserDao {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ifpe-20151-dsw3-projetoPU2");
    private EntityManager em = factory.createEntityManager();

    public User getUsuario(String nomeUsuario, String senha) {

        try {
            User usuario = (User) em.createQuery("SELECT u from User u where u.nomeUsuario = :name and u.senha = :senha").setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirUsuario(User usuario) {
        try {
            em.persist(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarUsuario(User usuario) {
        try {
            em.remove(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
