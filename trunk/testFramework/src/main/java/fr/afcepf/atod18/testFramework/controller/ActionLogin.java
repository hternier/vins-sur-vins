package fr.afcepf.atod18.testFramework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.core.action.Action;



public class ActionLogin extends Action {

	@Override
	public String execute(HttpServletRequest paramRequest,
			HttpServletResponse paramResponse) {
		
		ActionLoginForm loginForm = getForm(ActionLoginForm.class);
		
		return "/success.jsp";
	}



}
