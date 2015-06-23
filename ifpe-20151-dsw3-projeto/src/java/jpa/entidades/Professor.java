package jpa.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
public class Professor extends Usuario implements Serializable, SampleEntity  {

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

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 37 * hash + Objects.hashCode(this.siape);
//        hash = 37 * hash + Objects.hashCode(this.lattes);
//        hash = 37 * hash + Objects.hashCode(this.site);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Professor other = (Professor) obj;
//        if (!Objects.equals(this.siape, other.siape)) {
//            return false;
//        }
//        if (!Objects.equals(this.lattes, other.lattes)) {
//            return false;
//        }
//        if (!Objects.equals(this.site, other.site)) {
//            return false;
//        }
//        return true;
//    }
    
    

}
