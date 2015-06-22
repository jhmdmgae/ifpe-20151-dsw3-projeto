package jpa.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import jsf.util.SampleEntity;

@Entity
@Table(name = "PROFESSOR")
@Access(AccessType.FIELD)
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Professor extends Usuario implements Serializable, SampleEntity {

    @Column(name = "SIAPE", length = 10, nullable = false, unique = true)
    private String siape;

    @Column(name = "LATTES", length = 255, nullable = true)
    private String lattes;

    @Column(name = "SITE", length = 255, nullable = true)
    private String site;

    @OneToMany(mappedBy = "orientador", fetch = FetchType.LAZY)
    private List<Aluno> orientandos;

    @Override
    public Long getId() {
        return id;
    }
    
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Aluno> getOrientandos() {
        return orientandos;
    }

    public void addOrientando(Aluno aluno) {
        orientandos.add(aluno);
    }

}
