package fr.afcepf.al18.framework.vingtSurStruts.factory;

import fr.afcepf.al18.framework.vingtSurStruts.core.action.Action;

public class ActionFactory {

	private final static ActionFactory INSTANCE = new ActionFactory();
	
	private ActionFactory(){}

	public static ActionFactory getInstance() {
		return INSTANCE;
	}
	
	public Action getAction(String actionName) {
		Action returnAction;
		try {
			returnAction = (Action) Class.forName(actionName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			returnAction = null;
		}
		
		return returnAction;
	}

}