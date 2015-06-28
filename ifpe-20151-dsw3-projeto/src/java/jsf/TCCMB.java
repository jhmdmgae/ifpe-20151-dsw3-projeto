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
import jpa.entidades.Acompanhamento;
import jsf.AcompanhamentoMB;
import jpa.entidades.AreaConhecimento;

@ManagedBean(name = "TCCMB")
@SessionScoped
public class TCCMB implements Serializable {

    private TCCDao tccDAO;
    private TCC tcc;
    private List<TCC> TCCList;
    private List<AreaConhecimento> areaList;
    private AreaConhecimento area;
    private AcompanhamentoMB acompanhamentoMB;
    private List<Acompanhamento> acompanhamentoList;

    public TCCMB() {
        tccDAO = new TCCDao();
        tcc = new TCC();
        TCCList = new ArrayList<TCC>();
    }

    public String salva() {
        tcc.addArea(area);
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

    public List<AreaConhecimento> getGrandeAreaList() {
        areaList = tccDAO.getGrandeAreaList();
        return areaList;
    }

    public List<AreaConhecimento> getAreaList(int grandeArea) {
        areaList = tccDAO.getAreaList(grandeArea);
        return areaList;
    }

    public List<AreaConhecimento> getSubAreaList(int grandeArea, int area) {
        areaList = tccDAO.getSubAreaList(grandeArea, area);
        return areaList;
    }

    public List<AreaConhecimento> getAreaEspList(int grandeArea, int area, int subarea) {
        areaList = tccDAO.getAreaEspList(grandeArea, area, subarea);
        return areaList;
    }

    public List<AreaConhecimento> getAreaConhecimentoList() {
        return areaList;
    }

    public AreaConhecimento getArea() {
        return area;
    }

    public void setArea(AreaConhecimento area) {
        this.area = area;
    }

    public String remove(TCC tcc) {
//        List<Acompanhamento> acompanhamentoList = acompanhamentoMB.getAcompanhamentoList(tcc);
//        if (acompanhamentos.size() != 0) {
//            for (Acompanhamento acomp : acompanhamentos) {
//                System.out.println("----------acomp id = " + acomp.getId());
//                acompanhamentoMB.remove(acomp);
//            }
//        }
        System.out.println("----------tcc id = " + tcc.getId());
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
