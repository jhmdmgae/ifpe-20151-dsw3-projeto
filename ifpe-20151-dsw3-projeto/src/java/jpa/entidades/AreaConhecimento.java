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

@Entity
@Table(name = "AREA")
public class AreaConhecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, unique = true)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AREA_PAI", referencedColumnName = "ID")
    private AreaConhecimento pai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pai")
    private List<AreaConhecimento> filhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AreaConhecimento getPai() {
        return pai;
    }

    public void setPai(AreaConhecimento pai) {
        this.pai = pai;
    }

    public List<AreaConhecimento> getFilhas() {
        return filhas;
    }

    public boolean addFilha(AreaConhecimento filha) {
        if (filhas == null) {
            filhas = new ArrayList<>();
        }
        return filhas.add(filha);
    }

    @Override
    public String toString() {
        return "area:[id: " + id + ",descricao: " + descricao + ",pai: " + (pai == null ? "nulo" : pai.getDescricao()) + "]";
    }

}
