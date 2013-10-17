package fr.afcepf.al18.framework.vingtSurStruts.configuration;

import java.util.Map;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ActionXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.FormXml;

public interface VingtSurStrutsParser {
	
	public Map<String, ActionXml> getActionsMap();
	
	public Map<String, FormXml> getFormMap();

}
