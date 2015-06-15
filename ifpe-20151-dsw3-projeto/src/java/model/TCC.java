package model;

import java.io.Serializable;
import model.Aluno;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author João Henrique 2
 */
@ManagedBean(name="tcc")
@RequestScoped
public class TCC implements Serializable{
    
    private String titulo;
    private Aluno aluno;
    private List<AreaConhecimento> areas;
    private Date dataDefesa;
    private String imprenta;
    private String resumo;
    private StatusTCC status;
    private SituacaoDefesa situacaoDefesa;
    private Date dataInicio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<AreaConhecimento> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaConhecimento> areas) {
        this.areas = areas;
    }

    public Date getDataDefesa() {
        return dataDefesa;
    }

    public void setDataDefesa(Date dataDefesa) {
        this.dataDefesa = dataDefesa;
    }

    public String getImprenta() {
        return imprenta;
    }

    public void setImprenta(String imprenta) {
        this.imprenta = imprenta;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public StatusTCC getStatus() {
        return status;
    }

    public void setStatus(StatusTCC status) {
        this.status = status;
    }

    public SituacaoDefesa getSituacaoDefesa() {
        return situacaoDefesa;
    }

    public void setSituacaoDefesa(SituacaoDefesa situacaoDefesa) {
        this.situacaoDefesa = situacaoDefesa;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public boolean equals(TCC tcc) {
        return this.getTitulo().equalsIgnoreCase(tcc.getTitulo());
    }
    
}
