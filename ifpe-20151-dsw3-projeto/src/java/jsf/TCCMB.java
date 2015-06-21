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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jpa.entidades.TCC;
import jpa.controle.TCCDao;

@ManagedBean(name = "TCCMB")
@SessionScoped
public class TCCMB implements Serializable{

    private TCCDao tccDAO = new TCCDao();
    private TCC tcc = new TCC();
    
    private final List<model.TCC> TCCList = new ArrayList<model.TCC>();
    
    public String salva() {
        
        tccDAO.inserirTCC(getTCC());
        
        return "main";
    }
    
    public List<TCC> getTCCList() {
        
        return tccDAO.getTCCList();
        
    }
    
    public String remove(TCC tcc) {
        
        tccDAO.deletarTCC(tcc);
        
        return "main";
    }
    
    public TCC editar(long id) {
        
        return tccDAO.getTCC(id);
        
    }

    public TCC getTCC() {
        return tcc;
    }

    public void setTCC(TCC tcc) {
        this.tcc = tcc;
    }
}
