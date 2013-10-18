package fr.afcepf.atod18.testFramework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Action;
import fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Forward;


@Action(actionName = "loginActionAnnotated",
		formName = "loginFormAnnotated",
		input = "/index.jsp",
		forwards = {
			@Forward(path = "/success.jsp"),
			@Forward(name = ActionLoginAnnotated.ERROR, path = "/error.jsp")
		})
public class ActionLoginAnnotated extends fr.afcepf.al18.framework.vingtSurStruts.commons.entities.Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String returnString = ActionLoginAnnotated.SUCCESS;
		
		ActionLoginFormAnnotated loginForm = this.getForm(ActionLoginFormAnnotated.class);
		
		if (!loginForm.getLogin().equals("toto") || !loginForm.getPassword().equals("toto")) {
			returnString = ActionLoginAnnotated.ERROR;
		}
		
		return returnString;
	}

}
