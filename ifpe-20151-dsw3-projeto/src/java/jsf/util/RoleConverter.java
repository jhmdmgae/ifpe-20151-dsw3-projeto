package jsf.util;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;
import javax.management.relation.Role;

/**
 *
 * @author João Henrique 2
 */
@FacesConverter("roleConverter")
 public class RoleConverter extends EnumConverter {
     public RoleConverter() {
         super(Role.class);
     }
 }
