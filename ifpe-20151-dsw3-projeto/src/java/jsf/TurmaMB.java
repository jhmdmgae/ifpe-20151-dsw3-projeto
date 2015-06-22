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

import jpa.entidades.Turma;
import jpa.controle.TurmaDao;

@ManagedBean(name = "TurmaMB")
@SessionScoped
public class TurmaMB implements Serializable{

    private TurmaDao turmaDAO = new TurmaDao();
    private Turma turma = new Turma();
    
    private List<Turma> TurmaList = null;
    
    public TurmaMB(){
        
        TurmaList = new ArrayList<Turma>();
        
    }
    
    public String salva() {
        
        turmaDAO.inserirTurma(getTurma());
        
        return "main";
    }
    
    public String editar() {
        
        turmaDAO.alterarTurma(turma);
        
        return "main";
    }
    
    public List<Turma> getTurmaList() {
        
        return turmaDAO.getTurmaList();
        
    }
    
    public String remove(Turma turma) {
        
        turmaDAO.deletarTurma(turma);
        
        return "main";
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public String listarTurma() {
        return "turma_list";
    }
    
    public String novoTurma() {
        this.turma = new Turma();
        return "turma_novo";
    }
}
