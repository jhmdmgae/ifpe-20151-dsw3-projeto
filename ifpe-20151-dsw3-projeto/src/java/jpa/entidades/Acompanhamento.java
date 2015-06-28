package jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jsf.util.SampleEntity;
/**
 *
 * @author João Henrique 2
 */    
@Entity
@Table(name = "ACOMPANHAMENTO")
public class Acompanhamento implements Serializable, SampleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TCC", referencedColumnName = "ID")
    private TCC tcc;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA", nullable = false)
    protected Date data;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "HORARIO_INICIO", nullable = false)
    protected Date horarioInicio;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "HORARIO_TERMINO", nullable = false)
    protected Date horarioTermino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TCC getTcc() {
        return tcc;
    }

    public void setTcc(TCC tcc) {
        this.tcc = tcc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(Date horarioTermino) {
        this.horarioTermino = horarioTermino;
    }
    
    
    
}
