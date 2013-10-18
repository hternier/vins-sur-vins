package fr.afcepf.atod17.vinsurvin.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Form;
import fr.afcepf.al18.framework.vingtSurStruts.core.action.ActionForm;

@Form("newsletterForm")
public class ActionNewsletterForm  extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8344489819914049899L;
	private String email;
	
	
    @Override
	public String[] validate(HttpServletRequest paramRequest) {
    	
    	List<String> message = new ArrayList<String>();
		String regexMail = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";

    	if (this.getEmail().isEmpty()) {
    		// Redirection Erreur
    		message.add("Le champ email ne peut pas être vide.");

        } else if (!this.getEmail().matches(regexMail)){
        	message.add("Le format de l'adresse mail n'est pas valide. Veuillez rééssayer.");
        
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
