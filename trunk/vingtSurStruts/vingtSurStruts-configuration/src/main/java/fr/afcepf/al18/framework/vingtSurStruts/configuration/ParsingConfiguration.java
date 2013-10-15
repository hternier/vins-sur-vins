package fr.afcepf.al18.framework.vingtSurStruts.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class ParsingConfiguration {

	// Chemin du fichier de configuration XML
	private static String config = "/WEB-INF/vingtSurStruts-config.xml";
	
	/*
	 * Construction des maps
	 */
	private Map<String, ActionXml> actionsMap = new HashMap<String, ActionXml>();
	private Map<String, FormXml> formMap = new HashMap<String, FormXml>();

	// Singleton
	private ParsingConfiguration() {
		parse();
	}

	private static ParsingConfiguration INSTANCE = new ParsingConfiguration();

	/**
	 * Singleton de ParsingConfiguration.
	 * 
	 * @return La classe ParsingConfiguration instanciée.
	 */
	public static ParsingConfiguration getINSTANCE() {
		return INSTANCE;
	}

	private void parse() {

		/*
		 * Initialisation du parsing du XML
		 */
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;

			builder = factory.newDocumentBuilder();

			Document document = builder.parse(config);
			Element racine = document.getDocumentElement();

			

			/*
			 * Les noeuds Actions
			 */
			NodeList actions = racine.getElementsByTagName("actions");
			for (int i = 0; i < actions.getLength(); i++) {
				Node action = actions.item(i);
				ActionXml actionXml = new ActionXml();

				NodeList actionElement = action.getChildNodes();
				for (int j = 0; j < actionElement.getLength(); j++) {
					Node parametre = actionElement.item(j);
					if (parametre.getNodeName().equals("action-name")) {
						parametre.getTextContent();
					}
					if (parametre.getNodeName().equals("url-pattern")) {
						parametre.getTextContent();
					}
					if (parametre.getNodeName().equals("form-name")) {
						parametre.getTextContent();
					}
				}
			}

			/*
			 * Les noeuds Forms
			 */
			NodeList forms = racine.getElementsByTagName("forms");
			for (int i = 0; i < forms.getLength(); i++) {
				Node form = actions.item(i);

				NodeList formElement = form.getChildNodes();
				for (int j = 0; j < formElement.getLength(); j++) {
					Node parametre = formElement.item(j);
					if (parametre.getNodeName().equals("form-class")) {
						parametre.getTextContent();
					}
					if (parametre.getNodeName().equals("form-name")) {
						parametre.getTextContent();
					}
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Retourne le chemin du fichier de configuration XML de vingtSurStruts.
	 * 
	 * @return Chemin du fichier de configuration XML.
	 */
	public static String getConfig() {
		return config;
	}

	/**
	 * Defini le chemin du fichier de configuration XML de vingtSurStruts. Par
	 * default : /WEB-INF/vingtSurStruts-config.xml
	 * 
	 * @param paramConfig
	 *            Chemin du fichier de configuration XML.
	 */
	public static void setConfig(String paramConfig) {
		config = paramConfig;
	}

	public Map<String, ActionXml> getActionsMap() {
		return actionsMap;
	}

	public Map<String, FormXml> getFormMap() {
		return formMap;
	}
	
	

}
