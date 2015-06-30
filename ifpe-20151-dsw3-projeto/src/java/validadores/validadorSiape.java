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
import jpa.entidades.Professor;
import jsf.ProfessorMB;

@FacesValidator("validadorSiape")
public class validadorSiape implements Validator {

    public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {

        ProfessorMB professormb = new ProfessorMB();

        List<Professor> ProfessorList = professormb.getProfessorList();

        if (ProfessorList.size() != 0) {
            for (Professor professor : ProfessorList) {
                System.out.println("------ matricula------ " + professor.getSiape());
                System.out.println("------ objeto   ------ " + o);
                if (professor.getSiape().equals((String)o)) {
                    System.out.println("------ entrou   ------ " + (String)o);
                    FacesMessage msg = new FacesMessage("Siape já existe", "Informe novamente");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    fc.addMessage(null, msg);
                    throw new ValidatorException(msg);
                }

            }
        }

    }
}
