package validadores;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import jpa.entidades.Aluno;
import jsf.AlunoMB;

@FacesValidator("validadorMatricula")
public class validadorMatricula implements Validator {

    public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {

        AlunoMB alunomb = new AlunoMB();

        List<Aluno> AlunoList = alunomb.getAlunoList();

        if (AlunoList.size() != 0) {
            for (Aluno aluno : AlunoList) {
                System.out.println("------ matricula------ " + aluno.getMatricula());
                System.out.println("------ objeto   ------ " + o);
                if (aluno.getMatricula().equals((String)o)) {
                    System.out.println("------ entrou   ------ " + (String)o);
                    FacesMessage msg = new FacesMessage("Matrícula já existe", "Informe novemanete");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    fc.addMessage(null, msg);
                    throw new ValidatorException(msg);
                }

            }
        }

    }
}
