package fr.afcepf.al18.framework.vingtSurStruts.core.factory;

import fr.afcepf.al18.framework.vingtSurStruts.commons.VingtSurStrutsException;
import fr.afcepf.al18.framework.vingtSurStruts.commons.entities.Action;

public class ActionFactory {
	
	private final static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String actionName) {
		Action returnAction;
		try {
			returnAction = (Action) Class.forName(actionName).newInstance();
		} catch (Exception e) {
			throw new VingtSurStrutsException(e);
		}
		
		return returnAction;
	}

}
