package fr.afcepf.al18.framework.vingtSurStruts.configuration.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Entité utilisée pour stocker la configuration des actions du fichier de
 * configuration vingtSurStruts-config.xml.
 * @author Nicolas Chalet
 */
public class ActionXml {

	private String actionName;
	private String urlPattern;
	private String formName;
	private String input;
	private List<ForwardXml> forwards = new ArrayList<ForwardXml>();

	public ActionXml() {

	}

	public ActionXml(String actionName, String urlPattern, String formName) {
		this.actionName = actionName;
		this.urlPattern = urlPattern;
		this.formName = formName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public List<ForwardXml> getForwards() {
		return forwards;
	}

	public void setForwards(List<ForwardXml> forwards) {
		this.forwards = forwards;
	}

}
