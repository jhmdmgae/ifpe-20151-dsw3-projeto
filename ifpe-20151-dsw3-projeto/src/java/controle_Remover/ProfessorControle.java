package controle_Remover;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model_Remover.Professor;

public class ProfessorControle {

    private Professor professor;
    private final List<Professor> ProfessorList = new ArrayList<Professor>();

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getProfessorList() {
        return ProfessorList;
    }

    public String cancel() {
        return "back";
    }

    public String addProfessor(Professor professor) {
        for (Professor ProfessorList1 : ProfessorList) {
            if (ProfessorList1.equals(professor)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setDetail("Professor já existente! Favor verificar os dados.");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("registerForm:Titulo", message);
                return "error";
            }
        }
        ProfessorList.add(professor);
        return "main";
    }

    public String editProfessor() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (professor.getNome().isEmpty()) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setDetail("Insira um nome para Professor");
            context.addMessage("registerForm:", message);
            return "error";
        }

        for (Professor ProfessorList1 : ProfessorList) {
            if (ProfessorList1 == professor) {
                ProfessorList1.setNome(professor.getNome());
                ProfessorList1.setEmail(professor.getEmail());
                ProfessorList1.setSenha(professor.getSenha());
                break;
            }
        }

        return "main";
    }

    public String deleteProfessor(Professor remove) {
        ProfessorList.remove(remove);
        return "main";
    }
    
    public String listarProfessor() {
//        reset(true);
        return "professor_list";
    }
}
