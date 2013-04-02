package fr.afcepf.atod17.vinsurvin.utils;

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

}
