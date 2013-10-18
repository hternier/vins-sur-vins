package fr.afcepf.atod18.testFramework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.commons.entities.Action;

public class ActionLogin extends Action {

	@Override
	public String execute(HttpServletRequest paramRequest,
			HttpServletResponse paramResponse) {
		
		String returnString = Action.SUCCESS;
		
		ActionLoginForm loginForm = this.getForm(ActionLoginForm.class);
		
		if (!loginForm.getLogin().equals("toto") || !loginForm.getPassword().equals("toto")) {
			returnString = Action.ERROR;
		}
		
		return returnString;
	}



}
