package fr.afcepf.al18.framework.vingtSurStruts.core.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Remplit le form avec les valeurs renvoyées par la requete.
 * @author Hadrien Ternier
 */
public class FormFeeder {
	
	// Constructeur par defaut
	private FormFeeder() {}
	
	// Singleton
	private FormFeeder INSTANCE = new FormFeeder();
	
	
	/**
	 * Singleton de FormFeeder.
	 * @return L'instance de la classe FormFeeder.
	 */
	public FormFeeder getINSTANCE() {
		return INSTANCE;
	}


	/**
	 * Remplit le form avec les valeurs d'une map.
	 * @param paramActionForm Le form à remplire.
	 * @param paramMap Les valeurs du form de la forme Map<NomParametre, Valeur>.
	 * @return Le form peuplé.
	 * @throws IllegalAccessException Exception si pas d'accès aux propriétés.
	 * @throws InvocationTargetException Exception de la methode d'accès aux propriétés.
	 */
	public ActionForm feed(ActionForm paramActionForm, Map<String, String> paramMap) throws IllegalAccessException, InvocationTargetException {
		
		BeanUtils.populate(paramActionForm, paramMap);
		
		return paramActionForm;
	}

}
