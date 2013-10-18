package fr.afcepf.atod17.vinsurvin.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Action;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.annotations.Forward;

@Action(urlPattern = "/newsletterAction.perform", 
		formName = "newsletterForm", 
		input = "/newsletter.jsp", forwards = {
		@Forward(path = "/newsletters.jsp"),
		@Forward(name = ActionNewsletter.ERROR, path = "/newsletterError.jsp") })
public class ActionNewsletter extends
		fr.afcepf.al18.framework.vingtSurStruts.core.action.Action {

	@Override
	public String execute(HttpServletRequest paramRequest,
			HttpServletResponse paramResponse) {

		String returnString = ActionNewsletter.SUCCESS;

		ActionNewsletterForm newsletterForm = this
				.getForm(ActionNewsletterForm.class);
		
		String regexMail = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";
		
		if (!newsletterForm.getEmail().matches(regexMail)) {
			returnString = ActionNewsletter.ERROR;
		}

		return returnString;
	}

}
