package fr.afcepf.al18.framework.vingtSurStruts.core.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al18.framework.vingtSurStruts.configuration.ParsingConfiguration;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ActionXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.FormXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ForwardXml;
import fr.afcepf.al18.framework.vingtSurStruts.core.factory.ActionFactory;
import fr.afcepf.al18.framework.vingtSurStruts.core.factory.ActionFormFactory;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ParsingConfiguration config;
	
	private Map<String, Action> actions;

	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		try {
			this.config = ParsingConfiguration.getINSTANCE(context);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		this.actions = new HashMap<String, Action>(config.getActionsMap().size());
		Map<String, ActionForm> forms = this.getForms();
		this.initActions(forms);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Action action = actions.get(req.getServletPath());
		ActionForm form = action.getForm();
		FormFeeder feeder = FormFeeder.getINSTANCE();
		try {
			action.setForm(feeder.feed(form, req.getParameterMap()));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		if (form.validate(req) != null) {
			
		} else {
			String retourAction = action.execute(req, resp);
			getServletContext().getRequestDispatcher(action.getForwards().get(retourAction)).forward(req, resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	private Map<String, ActionForm> getForms() {
		
		Map<String, ActionForm> actionForms = new HashMap<String, ActionForm>(this.config.getFormMap().size());;
		ActionFormFactory formFactory = ActionFormFactory.getInstance();
		Map<String, FormXml> parsedMap = this.config.getFormMap();
		for (Entry<String, FormXml> entry : parsedMap.entrySet()) {
			actionForms.put(entry.getKey(), formFactory.getActionForm(entry.getValue().getFormClass()));
		}
		
		return actionForms;
	}
	
	private void initActions(Map<String, ActionForm> actionForms) {
		ActionFactory actionFactory = ActionFactory.getInstance();
		Map<String, ActionXml> parsedMap = this.config.getActionsMap();
		
		for (Entry<String, ActionXml> entry : parsedMap.entrySet()) {
			ActionXml actionXml = entry.getValue();
			Action action = actionFactory.getAction(actionXml.getActionName());
			
			action.setForm(actionForms.get(actionXml.getFormName()));
			
			action.setInput(actionXml.getInput());
			
			Map<String, String> forwards = new HashMap<String, String>();
			
			for (ForwardXml forward : actionXml.getForwards()) {
				forwards.put(forward.getName(), forward.getPath());
			}
			
			action.setForwards(forwards);
			
			actions.put(entry.getKey(), action);
		}
	}

}
