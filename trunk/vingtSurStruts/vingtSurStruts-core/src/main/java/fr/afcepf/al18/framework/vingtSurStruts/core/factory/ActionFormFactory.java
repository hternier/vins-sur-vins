package fr.afcepf.al18.framework.vingtSurStruts.core.factory;

import fr.afcepf.al18.framework.vingtSurStruts.core.action.ActionForm;

public class ActionFormFactory {
	
	private static final ActionFormFactory instance = new ActionFormFactory();
	
	private ActionFormFactory(){}
	
	public static ActionFormFactory getInstance() {
		return instance;
	}

	public ActionForm getActionForm(String actionFormName) {
		ActionForm returnAction;
		try {
			returnAction = (ActionForm) Class.forName(actionFormName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			returnAction = null;
		}
		
		return returnAction;
	}
	
}
