package jsf;

/**
 *
 * @author João Henrique 2
 */
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jpa.entidades.User;
import jpa.controle.UserDao;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginMB {

    private UserDao usuarioDAO = new UserDao();
    private User usuario = new User();

    public String envia() {

        usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
        if (usuario == null) {
            usuario = new User();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            return "main";
        }

    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
