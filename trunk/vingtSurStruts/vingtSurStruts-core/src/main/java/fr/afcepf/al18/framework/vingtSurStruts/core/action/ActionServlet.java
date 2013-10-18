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

import org.apache.commons.lang.StringUtils;

import fr.afcepf.al18.framework.vingtSurStruts.commons.VingtSurStrutsException;
import fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Form;
import fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Forward;
import fr.afcepf.al18.framework.vingtSurStruts.commons.entities.Action;
import fr.afcepf.al18.framework.vingtSurStruts.commons.entities.ActionForm;
import fr.afcepf.al18.framework.vingtSurStruts.commons.utils.UrlPatternUtils;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.ParsingAnnotation;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.ParsingConfiguration;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ActionXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.FormXml;
import fr.afcepf.al18.framework.vingtSurStruts.configuration.entities.ForwardXml;
import fr.afcepf.al18.framework.vingtSurStruts.core.factory.ActionFactory;
import fr.afcepf.al18.framework.vingtSurStruts.core.factory.ActionFormFactory;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ParsingConfiguration configXml;
	
	private ParsingAnnotation configAnnotations;
	
	private Map<String, Action> actions;

	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		this.configXml = ParsingConfiguration.getINSTANCE(context);
		if (configXml.getPackages() != null) {
			configAnnotations = ParsingAnnotation.getInstance(configXml.getPackages());
		}
			
		this.actions = new HashMap<String, Action>(configXml.getActionsMap().size());
		Map<String, ActionForm> forms = this.getForms();
		this.initActions(forms);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String urlPattern = req.getServletPath();
		Action action = actions.get(UrlPatternUtils.toActionKey(urlPattern));
		
		if (action == null) {
			throw new VingtSurStrutsException("le pattern " + urlPattern + " n'est relié a aucune action");
		}
		
		ActionForm form = action.getForm();
		FormFeeder feeder = FormFeeder.getINSTANCE();
		try {
			action.setForm(feeder.feed(form, req.getParameterMap()));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		String[] messagesValidate = form.validate(req);
		// Si form invalide
		if (messagesValidate != null) {
			
			if (StringUtils.isEmpty(action.getInput())) {
				throw new VingtSurStrutsException("L'input de l'action " + action.getClass().getCanonicalName() + " est obligatoire en cas de validation en échec");
			}
			
			// Ajout des messages de validation au form
			form.setMessagesValidate(messagesValidate);
			
			// Ajout des paramètres du form à la réponse (avec message Erreur)
			req.setAttribute(form.getFormName(), form);
			
			// Renvoi de la page avec les paramètres
			getServletContext().getRequestDispatcher(action.getInput()).forward(req, resp);
		} 
		// Sinon form valide
		else {
			String retourAction = action.execute(req, resp);
			
			this.checkExecuteResultAndForwards(retourAction, action.getForwards());
			
			this.getServletContext().getRequestDispatcher(action.getForwards().get(retourAction)).forward(req, resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@SuppressWarnings("rawtypes")
	private Map<String, ActionForm> getForms() {
		
		Map<String, ActionForm> actionForms = new HashMap<String, ActionForm>(this.configXml.getFormMap().size());
		ActionFormFactory formFactory = ActionFormFactory.getInstance();
		
		for (Entry<String, FormXml> entry : this.configXml.getFormMap().entrySet()) {
			if (actionForms.containsKey(entry.getKey())) {
				throw new VingtSurStrutsException("Le ActionForm " + entry.getKey() + " est défini deux fois.");
			}
			actionForms.put(entry.getKey(), formFactory.getActionForm(entry.getValue().getFormClass()));
		}
		
		if (configAnnotations != null) {
			for (Entry<String, Class> entry : configAnnotations.getFormMap().entrySet()) {
				if (actionForms.containsKey(entry.getKey())) {
					throw new VingtSurStrutsException("Le ActionForm " + entry.getKey() + " est défini deux fois.");
				}
				actionForms.put(entry.getKey(), this.classToForm(entry.getValue()));
			}
		}
		
		return actionForms;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ActionForm classToForm(Class clazz) {
		ActionFormFactory formFactory = ActionFormFactory.getInstance();
		
		ActionForm returnForm = formFactory.getActionForm(clazz.getCanonicalName());
		Form annotationForm = (Form) clazz.getAnnotation(Form.class);
		returnForm.setFormName(annotationForm.value());
		
		return returnForm;
		
	}
	
	@SuppressWarnings("rawtypes")
	private void initActions(Map<String, ActionForm> actionForms) {
		ActionFactory actionFactory = ActionFactory.getInstance();
		Map<String, ActionXml> parsedMap = this.configXml.getActionsMap();
		
		for (Entry<String, ActionXml> entry : parsedMap.entrySet()) {
			ActionXml actionXml = entry.getValue();
			Action action = actionFactory.getAction(actionXml.getActionName());
			
			action.setForm(actionForms.get(actionXml.getFormName()));
			
			action.setInput(actionXml.getInput());
			
			action.getForm().setFormName(actionXml.getFormName());
			
			Map<String, String> forwards = new HashMap<String, String>();
			
			for (ForwardXml forward : actionXml.getForwards()) {
				if (forwards.containsKey(forward.getName())) {
					throw new VingtSurStrutsException("Les forwards de l'action " + actionXml.getActionName() + " sont incorrects, plusieurs forwards ont le même champ name.");
				}
				forwards.put(forward.getName(), forward.getPath());
			}
			
			action.setForwards(forwards);
			
			if (this.actions.containsKey(entry.getKey())) {
				throw new VingtSurStrutsException("Le Action " + entry.getKey() + " est défini deux fois.");
			}
			
			this.actions.put(entry.getKey(), action);
		}
		
		if (this.configAnnotations != null) {
			for (Entry<String, Class> entry : this.configAnnotations.getActionsMap().entrySet()) {
				if (this.actions.containsKey(entry.getKey())) {
					throw new VingtSurStrutsException("Le Action " + entry.getKey() + " est défini deux fois.");
				}
				
				this.actions.put(entry.getKey(), classToAction(entry.getValue(), actionForms));
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Action classToAction(Class value, Map<String, ActionForm> actionForms) {
		ActionFactory actionFactory = ActionFactory.getInstance();
		
		Action actionRetour = actionFactory.getAction(value.getCanonicalName());
		
		fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Action actionAnnonation = (fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Action) value.getAnnotation(fr.afcepf.al18.framework.vingtSurStruts.commons.annotations.Action.class);
		
		ActionForm form = actionForms.get(actionAnnonation.formName());
		
		if (form == null) {
			throw new VingtSurStrutsException("Le ActionForm " + actionAnnonation.formName() + " renseigné dans l'action " + actionAnnonation.actionName() + " n'existe pas.");
		}
		
		actionRetour.setForm(form);
		actionRetour.setInput(actionAnnonation.input());
		
		for (Forward forwardAnnotation : actionAnnonation.forwards()) {
			if (actionRetour.getForwards().containsKey(forwardAnnotation.name())) {
				throw new VingtSurStrutsException("Les forwards de l'action " + actionAnnonation.actionName() + " sont incorrects, plusieurs forwards ont le même champ name.");
			}
			actionRetour.getForwards().put(forwardAnnotation.name(), forwardAnnotation.path());
		}
		
		return actionRetour;
	}
	
	private void checkExecuteResultAndForwards (String executeResult, Map<String, String> forwards) {
		
		for (Entry<String, String> entry : forwards.entrySet()) {
			if (StringUtils.equals(executeResult, entry.getKey())) {
				return;
			}
		}
		
		throw new VingtSurStrutsException("Le retour de la méthode execute ne correspond pas aux forwards de l'action.");
	}


}
