package jsf.util;

import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Henrique 2
 */
@javax.faces.bean.ManagedBean
@ApplicationScoped
public class ResponseHeader {
    public void setNoCache() {
        HttpServletResponse response = (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Cache-Control", "no-cache, no-store");
    }
}
