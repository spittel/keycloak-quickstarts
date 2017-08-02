package org.keycloak.quickstart.profilejee;


import org.jboss.ejb3.annotation.SecurityDomain;
import org.keycloak.adapters.saml.SamlPrincipal;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

@Stateless
@SecurityDomain("keycloak")
public class SimpleEJB {
	@RolesAllowed("EmployeeUser")
	public String getAllSamlPrincipalAttributes(HttpServletRequest req) {
		SamlPrincipal principal = (SamlPrincipal) req.getUserPrincipal();
		String all = "";
		
		for (String name : principal.getAttributeNames()) {
			all += "<br/>" + name;
			for (String attrib : principal.getAttributes(name)) 
				all += "<br/>&nbsp;&nbsp;&nbsp;&nbsp;" + attrib;
		}
		return all;
	}
}
