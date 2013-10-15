package fr.afcepf.al18.framework.vingtSurStruts.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	
	private ActionForm form;

	public ActionForm getForm() {
		return form;
	}

	@SuppressWarnings("unchecked")
	public <T extends ActionForm> T getForm(Class<T> clazz) {
		return (T) form;
	}

	public void setForm(ActionForm form) {
		this.form = form;
	}
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
