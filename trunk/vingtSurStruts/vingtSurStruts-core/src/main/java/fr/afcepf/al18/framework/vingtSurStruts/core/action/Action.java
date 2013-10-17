package fr.afcepf.al18.framework.vingtSurStruts.core.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	
	private ActionForm form;
	private Map<String, String> forwards = new HashMap<String, String>();
	private String input;

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
	
	public Map<String, String> getForwards() {
		return forwards;
	}

	public void setForwards(Map<String, String> forwards) {
		this.forwards = forwards;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
