package fr.afcepf.al18.framework.vingtSurStruts.core.action;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public abstract class ActionForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ActionServlet servlet;

	public ActionServlet getServlet() {
		return servlet;
	}

	public void setServlet(ActionServlet servlet) {
		this.servlet = servlet;
	}
	
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
