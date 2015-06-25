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

import jpa.entidades.Acompanhamento;
import jpa.controle.AcompanhamentoDao;

@ManagedBean(name = "AcompanhamentoMB")
@SessionScoped
public class AcompanhamentoMB implements Serializable{

    private AcompanhamentoDao acompanhamentoDAO;
    private Acompanhamento acompanhamento;
    private List<Acompanhamento> AcompanhamentoList;
    
    public AcompanhamentoMB(){
        
        acompanhamentoDAO = new AcompanhamentoDao();
        acompanhamento = new Acompanhamento();
        AcompanhamentoList = new ArrayList<Acompanhamento>();
        
    }
    
    public String salva() {
        
        System.out.println("tcc = "+getAcompanhamento().getTcc());
        acompanhamentoDAO.inserirAcompanhamento(getAcompanhamento());
        
        return "main";
    }
    
    public String editar() {
        
        acompanhamentoDAO.alterarAcompanhamento(acompanhamento);
        
        return "main";
    }
    
    public List<Acompanhamento> getAcompanhamentoList() {
        
        return acompanhamentoDAO.getAcompanhamentoList();
        
    }
    
    public String remove(Acompanhamento acompanhamento) {
        
        acompanhamentoDAO.deletarAcompanhamento(acompanhamento);
        
        return "main";
    }

    public Acompanhamento getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Acompanhamento acompanhamento) {
        this.acompanhamento = acompanhamento;
    }
    
    public String listarAcompanhamento() {
        return "acompanhamento_list";
    }
    
    public String novoAcompanhamento() {
        this.acompanhamento = new Acompanhamento();
        return "acompanhamento_novo";
    }
}
