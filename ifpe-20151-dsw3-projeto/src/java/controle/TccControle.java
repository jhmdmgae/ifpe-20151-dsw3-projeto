package controle;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TCC;

public class TccControle {

    private TCC tcc;
    private final List<TCC> TCCList = new ArrayList<TCC>();

    public TCC getTCC() {
        return tcc;
    }

    public void setTCC(TCC tcc) {
        this.tcc = tcc;
    }

    public List<TCC> getTCCList() {
        return TCCList;
    }

    public String cancel() {
        return "back";
    }

    public String addTCC(TCC tcc) {
        for (TCC tccList1 : TCCList) {
            if (tccList1.equals(tcc)) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setDetail("TCC já existente! Favor verificar os dados.");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("registerForm:Titulo", message);
                return "error";
            }
        }
        TCCList.add(tcc);
        return "main";
    }

    public String editTCC() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (tcc.getTitulo().isEmpty()) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setDetail("Insira um titulo para o TCC");
            context.addMessage("registerForm:", message);
            return "error";
        }

        for (TCC tccList1 : TCCList) {
            if (tccList1 == tcc) {
                tccList1.setTitulo(tcc.getTitulo());
                tccList1.setDataDefesa(tcc.getDataDefesa());
                tccList1.setStatus(tcc.getStatus());
                break;
            }
        }

        return "main";
    }

    public String deleteTCC(TCC remove) {
        TCCList.remove(remove);
        return "main";
    }
    
    public String listarTCC() {
//        reset(true);
        return "tcc_list";
    }
}
