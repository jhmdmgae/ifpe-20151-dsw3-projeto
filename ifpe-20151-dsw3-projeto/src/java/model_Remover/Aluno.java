package model_Remover;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author João Henrique 2
 */
@ManagedBean(name="aluno")
@RequestScoped
public class Aluno extends Usuario {
    
    private String matricula;
    private StatusAluno status;
    private Turma turma;
    
}
