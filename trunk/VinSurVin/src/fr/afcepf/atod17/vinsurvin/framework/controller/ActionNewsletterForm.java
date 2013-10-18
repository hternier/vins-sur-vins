package fr.afcepf.atod17.vinsurvin.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Form;
import fr.afcepf.al18.framework.vingtSurStruts.commons.entities.ActionForm;

@Form("newsletterForm")
public class ActionNewsletterForm  extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String email;
	
	
    @Override
	public String[] validate(HttpServletRequest paramRequest) {
    	
    	List<String> message = new ArrayList<String>();

    	if (this.getEmail().isEmpty()) {
    		// Redirection Erreur
    		message.add("Le champ email ne peut pas être vide.");

        
        } else {
        	// Redirection Success
        }
    	
    	if (message.isEmpty()) {
    		return null;
    	}
    	
    	return message.toArray(new String[message.size()]);
	}


	
    
    /*
     * Setter et Getter
     */
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
