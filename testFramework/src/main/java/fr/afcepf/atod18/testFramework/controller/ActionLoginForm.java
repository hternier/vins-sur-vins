package fr.afcepf.atod18.testFramework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.afcepf.al18.framework.vingtSurStruts.core.action.ActionForm;

public class ActionLoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	
	
    @Override
	public String[] validate(HttpServletRequest paramRequest) {
    	
    	List<String> message = new ArrayList<String>();
    	
    	if (!this.getLogin().equals("toto") || !this.getPassword().equals("toto")) {
    		// Redirection Erreur
    		message.add("Error login");
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
    
	public String getLogin() {
		return login;
	}
	public void setLogin(String paramLogin) {
		login = paramLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String paramPassword) {
		password = paramPassword;
	}
    
    
}
