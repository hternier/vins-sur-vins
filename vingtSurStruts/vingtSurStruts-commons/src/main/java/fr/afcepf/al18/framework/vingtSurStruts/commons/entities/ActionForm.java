package fr.afcepf.al18.framework.vingtSurStruts.commons.entities;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public abstract class ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String formName;
	private String[] messagesValidate;

	public String getFormName() {
		return formName;
	}

	public void setFormName(String paramFormName) {
		formName = paramFormName;
	}

	public String[] getMessagesValidate() {
		return messagesValidate;
	}

	public void setMessagesValidate(String[] paramMessagesValidate) {
		messagesValidate = paramMessagesValidate;
	}

	/**
	 * 
	 * @param request
	 * @return null si la validation est réussie.
	 */
	public String[] validate(ServletRequest request) {
		try {
			return validate((HttpServletRequest) request);
		} catch (ClassCastException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return null si la validation est réussie.
	 */
	public String[] validate(HttpServletRequest request) {
		return null;
	}

}
