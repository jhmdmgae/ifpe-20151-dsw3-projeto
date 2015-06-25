package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import jsf.util.SampleEntity;

@Entity
@Table(name = "AREA")
public class AreaConhecimento implements Serializable, SampleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;
    
    @Column(name = "GRANDE_AREA", nullable = false)
    private int grandeArea;
    
    @Column(name = "AREA", nullable = false)
    private int area;
    
    @Column(name = "SUB_AREA", nullable = false)
    private int subArea;
    
    @Column(name = "AREA_ESPECIFICA", nullable = false)
    private int areaEspecifica;
    
    @Column(name = "DIGITO", nullable = false)
    private int digito;
    
    @Column(name = "TITULO", nullable = false)
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getGrandeArea() {
        return grandeArea;
    }

    public void setGrandeArea(int grandeArea) {
        this.grandeArea = grandeArea;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSubArea() {
        return subArea;
    }

    public void setSubArea(int subArea) {
        this.subArea = subArea;
    }

    public int getAreaEspecifica() {
        return areaEspecifica;
    }

    public void setAreaEspecifica(int areaEspecifica) {
        this.areaEspecifica = areaEspecifica;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
