package fr.afcepf.atod18.testFramework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Action;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Forward;


@Action(urlPattern = "/loginActionAnnotated.perform",
		formName = "loginFormAnnotated",
		input = "/index.jsp",
		forwards = {
			@Forward(path = "/success.jsp"),
			@Forward(name = ActionLoginAnnotated.ERROR, path = "/error.jsp")
		})
public class ActionLoginAnnotated extends fr.afcepf.al18.framework.vingtSurStruts.core.action.Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String returnString = ActionLoginAnnotated.SUCCESS;
		
		ActionLoginForm loginForm = this.getForm(ActionLoginForm.class);
		
		if (!loginForm.getLogin().equals("toto") || !loginForm.getPassword().equals("toto")) {
			returnString = ActionLoginAnnotated.ERROR;
		}
		
		return returnString;
	}

}
