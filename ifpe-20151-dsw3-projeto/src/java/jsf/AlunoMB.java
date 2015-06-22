package jsf;

/**
 *
 * @author João Henrique 2
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jpa.entidades.Aluno;
import jpa.controle.AlunoDao;

@ManagedBean(name = "AlunoMB")
@SessionScoped
public class AlunoMB implements Serializable{

    private AlunoDao alunoDAO;
    private Aluno aluno;
    private List<Aluno> AlunoList;
    
    public AlunoMB(){
        
        alunoDAO = new AlunoDao();
        aluno = new Aluno();
        AlunoList = new ArrayList<Aluno>();
        
    }
    
    public String salva() {
        
        System.out.println("nome = "+getAluno().getNome());
        alunoDAO.inserirAluno(getAluno());
        
        return "main";
    }
    
    public String editar() {
        
        alunoDAO.alterarAluno(aluno);
        
        return "main";
    }
    
    public List<Aluno> getAlunoList() {
        
        return alunoDAO.getAlunoList();
        
    }
    
    public String remove(Aluno aluno) {
        
        alunoDAO.deletarAluno(aluno);
        
        return "main";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public String listarAluno() {
        return "aluno_list";
    }
    
    public String novoAluno() {
        this.aluno = new Aluno();
        return "aluno_novo";
    }
}
