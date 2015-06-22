package jpa.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import jsf.util.SampleEntity;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable, SampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ANO", length = 4, nullable = false)
    private String ano;

    @Column(name = "SEMESTRE", nullable = false)
    private int semestre;

    @Column(name = "CODIGO", length = 6, nullable = false)
    private String codigo;

    @Size(max = 60)
    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        if (alunos == null) {
            alunos = new ArrayList<>();
        }

        this.alunos.add(aluno);
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 31 * hash + Objects.hashCode(this.id);
//        hash = 31 * hash + Objects.hashCode(this.ano);
//        hash = 31 * hash + this.semestre;
//        hash = 31 * hash + Objects.hashCode(this.codigo);
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
//        final Turma other = (Turma) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        if (!Objects.equals(this.ano, other.ano)) {
//            return false;
//        }
//        if (this.semestre != other.semestre) {
//            return false;
//        }
//        if (!Objects.equals(this.codigo, other.codigo)) {
//            return false;
//        }
//        return true;
//    }
    
    
}
