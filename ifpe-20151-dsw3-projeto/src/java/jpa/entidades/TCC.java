package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

@Entity
@Table(name = "TCC")
@SecondaryTable(name = "ARQUIVO_TCC", pkJoinColumns = {
    @PrimaryKeyJoinColumn(name = "ID_TCC")})
public class TCC implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID_USUARIO")
    private Aluno aluno;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TCC_AREA", joinColumns = {
        @JoinColumn(name = "ID_TCC")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_AREA")
            }
    )
    private List<AreaConhecimento> areas;

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_DEFESA", nullable = true)
    private Date dataDefesa;

    @Column(name = "IMPRENTA", nullable = true)
    private String imprenta;

    @Column(name = "RESUMO", nullable = true)
    private String resumo;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ARQUIVO", table = "ARQUIVO_TCC", nullable = true)
    private byte[] arquivo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS_TCC", nullable = true)
    private StatusTCC status;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SITUACAO_DEFESA", nullable = true)
    private SituacaoDefesa situacaoDefesa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INICIO", nullable = false)
    private Date dataInicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.aluno.setTcc(this);
    }

    public List<AreaConhecimento> getAreas() {
        return areas;
    }

    public boolean addArea(AreaConhecimento area) {
        if (areas == null) {
            areas = new ArrayList<>();
        }
        return areas.add(area);
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

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
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

}
