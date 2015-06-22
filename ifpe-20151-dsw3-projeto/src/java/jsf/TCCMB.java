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

import jpa.entidades.TCC;
import jpa.controle.TCCDao;

@ManagedBean(name = "TCCMB")
@SessionScoped
public class TCCMB implements Serializable{

    private TCCDao tccDAO = new TCCDao();
    private TCC tcc = new TCC();
    
    private List<TCC> TCCList = null;
    
    public TCCMB(){
        
        TCCList = new ArrayList<TCC>();
        
    }
    
    public String salva() {
        
        tccDAO.inserirTCC(getTCC());
        
        return "main";
    }
    
    public String editar() {
        
        tccDAO.alterarTCC(tcc);
        
        return "main";
    }
    
    public List<TCC> getTCCList() {
        
        return tccDAO.getTCCList();
        
    }
    
    public String remove(TCC tcc) {
        
        tccDAO.deletarTCC(tcc);
        
        return "main";
    }

    public TCC getTCC() {
        return tcc;
    }

    public void setTCC(TCC tcc) {
        this.tcc = tcc;
    }
    
    public String listarTCC() {
        return "tcc_list";
    }
    
    public String novoTCC() {
        this.tcc = new TCC();
        return "tcc_novo";
    }
}
