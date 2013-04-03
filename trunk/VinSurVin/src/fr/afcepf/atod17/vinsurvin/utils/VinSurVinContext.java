package fr.afcepf.atod17.vinsurvin.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VinSurVinContext {
	
	private static ApplicationContext ctx;
	
	public static ApplicationContext getSpringContext() {
		
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		}
		
		return ctx;
	}
	
	public static void afficherErreur(String titre, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(titre, detail));
	}

}
