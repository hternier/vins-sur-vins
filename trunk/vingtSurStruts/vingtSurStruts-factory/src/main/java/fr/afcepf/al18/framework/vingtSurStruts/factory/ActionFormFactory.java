package fr.afcepf.al18.framework.vingtSurStruts.factory;

import fr.afcepf.al18.framework.vingtSurStruts.core.action.ActionForm;

public class ActionFormFactory {
	
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
