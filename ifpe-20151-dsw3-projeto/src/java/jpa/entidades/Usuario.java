package jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author JoÃ£o Henrique 2
 */
@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "DISC_USUARIO",
        discriminatorType = DiscriminatorType.STRING,
        length = 1)
@Access(AccessType.FIELD)
//@SecondaryTable(name = "FOTO_USUARIO", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID_USUARIO"))
public abstract class Usuario implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    protected String nome;

    @Column(name = "EMAIL", length = 50, nullable = false)
    protected String email;

    @Size(min = 6, max = 16)
    @Column(name = "SENHA", length = 20, nullable = false)
    protected String senha;

    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    protected Date dataNascimento;

    @ElementCollection
    @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "ID_USUARIO", nullable = false))
    @Column(name = "TELEFONE")
    protected Collection<String> telefones;

    @Lob
    @Basic(fetch = FetchType.LAZY)
//    @Column(name = "FOTO", table = "FOTO_USUARIO", nullable = true)
    @Column(name = "FOTO", nullable = true)
    protected byte[] foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Collection<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Collection<String> telefones) {
        this.telefones = telefones;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
