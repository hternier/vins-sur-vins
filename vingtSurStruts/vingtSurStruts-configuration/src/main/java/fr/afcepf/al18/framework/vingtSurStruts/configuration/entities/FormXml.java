package fr.afcepf.al18.framework.vingtSurStruts.configuration.entities;

/**
 * Entité utilisée pour stocker la configuration des forms du fichier de
 * configuration vingtSurStruts-config.xml.
 * @author Nicolas Chalet
 */
public class FormXml {
	
	private String formClass;
	private String formName;

	public FormXml() {
		
	}
	
	public FormXml(String formClass, String formName) {
		this.formClass = formClass;
		this.formName = formName;
	}

	public String getFormClass() {
		return formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
