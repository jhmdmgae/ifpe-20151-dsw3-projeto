package controle_Remover;

import model_Remover.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UserHandler {

    private User user;
    private final List<User> userList = new ArrayList<User>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String cancel() {
        return "back";
    }

    public String addUser(User user) {
        for (User userList1 : userList) {
            if (userList1.equals(user)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setDetail("Usuário já existente! Favor verificar os dados.");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("registerForm:name", message);
                return "error";
            }
        }
        userList.add(user);
        return "main";
    }

    public String editUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (user.getName().isEmpty() || user.getSalary() < 722.0) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setDetail("Valor de salário inválido, deve ser maior ou igual à R$ 722,00");
            context.addMessage("registerForm:salary", message);
            return "error";
        }

        for (User userList1 : userList) {
            if (userList1 == user) {
                userList1.setName(user.getName());
                userList1.setBirthDate(user.getBirthDate());
                userList1.setSalary(user.getSalary());
                break;
            }
        }

        return "main";
    }

    public String deleteUser(User remove) {
        userList.remove(remove);
        return "main";
    }
}
