package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Aluno;

public class AlunoControle {

    private Aluno aluno;
    private final List<Aluno> AlunoList = new ArrayList<Aluno>();

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunoList() {
        return AlunoList;
    }

    public String cancel() {
        return "back";
    }

    public String addAluno(Aluno aluno) {
        for (Aluno AlunoList1 : AlunoList) {
            if (AlunoList1.equals(aluno)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setDetail("Aluno já existente! Favor verificar os dados.");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("registerForm:Titulo", message);
                return "error";
            }
        }
        AlunoList.add(aluno);
        return "main";
    }

    public String editAluno() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (aluno.getNome().isEmpty()) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setDetail("Insira um nome para Aluno");
            context.addMessage("registerForm:", message);
            return "error";
        }

        for (Aluno AlunoList1 : AlunoList) {
            if (AlunoList1 == aluno) {
                AlunoList1.setNome(aluno.getNome());
                AlunoList1.setEmail(aluno.getEmail());
                AlunoList1.setSenha(aluno.getSenha());
                break;
            }
        }

        return "main";
    }

    public String deleteAluno(Aluno remove) {
        AlunoList.remove(remove);
        return "main";
    }
    
    public String listarAluno() {
//        reset(true);
        return "aluno_list";
    }
}
