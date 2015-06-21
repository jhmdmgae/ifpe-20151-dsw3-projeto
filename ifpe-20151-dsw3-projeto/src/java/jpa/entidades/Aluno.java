package jpa.entidades;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
@Access(AccessType.FIELD)
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Aluno extends Usuario implements Serializable {

    @Column(name = "MATRICULA", length = 20, nullable = false, unique = true)
    private String matricula;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS_ALUNO", nullable = false)
    private StatusAluno status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_TURMA", referencedColumnName = "ID")
    private Turma turma;

    @OneToOne(mappedBy = "aluno", optional = true)
    private TCC tcc;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_PROFESSOR", referencedColumnName = "ID_USUARIO")
    private Professor orientador;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public TCC getTcc() {
        return tcc;
    }

    public void setTcc(TCC tcc) {
        this.tcc = tcc;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor professor) {
        this.orientador = professor;
    }

    @Override
    public String toString() {
       return "aluno:[id: " + id + ",matricula: " + matricula + ",orientador: " + orientador.getNome() + "]";
    }

}
