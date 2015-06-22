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

import jpa.entidades.Professor;
import jpa.controle.ProfessorDao;

@ManagedBean(name = "ProfessorMB")
@SessionScoped
public class ProfessorMB implements Serializable{

    private ProfessorDao professorDAO = new ProfessorDao();
    private Professor professor = new Professor();
    
    private List<Professor> ProfessorList = null;
    
    public ProfessorMB(){
        
        ProfessorList = new ArrayList<Professor>();
        
    }
    
    public String salva() {
        
        System.out.println("id = "+getProfessor().getId());
        professorDAO.inserirProfessor(getProfessor());
        
        return "main";
    }
    
    public String editar() {
        
        professorDAO.alterarProfessor(professor);
        
        return "main";
    }
    
    public List<Professor> getProfessorList() {
        
        return professorDAO.getProfessorList();
        
    }
    
    public String remove(Professor professor) {
        
        professorDAO.deletarProfessor(professor);
        
        return "main";
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public String listarProfessor() {
        return "professor_list";
    }
    
    public String novoProfessor() {
        this.professor = new Professor();
        return "professor_novo";
    }
}
