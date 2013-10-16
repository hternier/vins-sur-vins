package fr.afcepf.al18.framework.vingtSurStruts.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ActionXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.FormXml;

/**
 * Classe de lecture du fichier de configuration vingtSurStruts-config.xml.
 * @author Hadrien Ternier
 */
public class ParsingConfiguration {

	// Chemin du fichier de configuration XML
	private String config;
	
	// Construction des maps
	private Map<String, ActionXml> actionsMap = new HashMap<String, ActionXml>();
	private Map<String, FormXml> formMap = new HashMap<String, FormXml>();

	// Constructeur par defaut
	private ParsingConfiguration(ServletContext context) {
		config = context.getRealPath("WEB-INF/vingtSurStruts-config.xml");
	}

	// Singleton
	private static ParsingConfiguration INSTANCE;

	/**
	 * Singleton de ParsingConfiguration.
	 * @return La classe ParsingConfiguration instanciée.
	 * @throws ParserConfigurationException Exception du traitement du fichier.
	 * @throws IOException Exception de lecture de fichier.
	 * @throws SAXException Exception lors du parsing du fichier.
	 */
	public static ParsingConfiguration getINSTANCE(ServletContext context) throws SAXException, IOException, ParserConfigurationException {
		if (INSTANCE == null) {
			INSTANCE = new ParsingConfiguration(context);
			INSTANCE.parse();
		}
		return INSTANCE;
	}

	private void parse() throws SAXException, IOException, ParserConfigurationException {
		
			/*
			 * Initialisation du parsing du XML
			 */
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;

			builder = factory.newDocumentBuilder();

			Document document = builder.parse(config);
			Element racine = document.getDocumentElement();

			actionsMap.clear();
			formMap.clear();
			
			
			/*
			 * Parsing des noeuds Actions
			 */
			NodeList actions = racine.getElementsByTagName("actions");
			for (int i = 0; i < actions.getLength(); i++) {
				Node action = actions.item(i);
				ActionXml actionXml = new ActionXml();

				NodeList actionElement = action.getChildNodes();
				for (int j = 0; j < actionElement.getLength(); j++) {
					Node parametre = actionElement.item(j);
					if (parametre.getNodeName().equals("action-name")) {
						actionXml.setActionName(parametre.getTextContent());
					}
					if (parametre.getNodeName().equals("url-pattern")) {
						actionXml.setUrlPattern(parametre.getTextContent());
					}
					if (parametre.getNodeName().equals("form-name")) {
						actionXml.setFormName(parametre.getTextContent());
					}
				}
				actionsMap.put(actionXml.getUrlPattern(), actionXml);
			}

			/*
			 * Parsing des noeuds Forms
			 */
			NodeList forms = racine.getElementsByTagName("forms");
			for (int i = 0; i < forms.getLength(); i++) {
				Node form = forms.item(i);
				FormXml formXml = new FormXml();

				NodeList formElement = form.getChildNodes();
				for (int j = 0; j < formElement.getLength(); j++) {
					Node parametre = formElement.item(j);
					if (parametre.getNodeName().equals("form-class")) {
						formXml.setFormClass(parametre.getTextContent());
					}
					if (parametre.getNodeName().equals("form-name")) {
						formXml.setFormName(parametre.getTextContent());
					}
				}
				formMap.put(formXml.getFormName(), formXml);
			}

	}

	/**
	 * Retourne le chemin du fichier de configuration XML de vingtSurStruts.
	 * @return Chemin du fichier de configuration XML.
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * Defini le chemin du fichier de configuration XML de vingtSurStruts. Par
	 * default : /WEB-INF/vingtSurStruts-config.xml
	 * @param paramConfig
	 *            Chemin du fichier de configuration XML.
	 */
	public void setConfig(String paramConfig) {
		config = paramConfig;
	}

	/**
	 * Liste des noeuds actions du fichier de configuration.
	 * @return La map des actions.
	 */
	public Map<String, ActionXml> getActionsMap() {
		return actionsMap;
	}

	/**
	 * Liste des noeuds forms du fichier de configuration.
	 * @return La map des forms.
	 */
	public Map<String, FormXml> getFormMap() {
		return formMap;
	}
	
	

}
