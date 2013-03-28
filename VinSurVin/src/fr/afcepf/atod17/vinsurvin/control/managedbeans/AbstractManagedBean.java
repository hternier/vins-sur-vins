package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractManagedBean {
	
	private static ApplicationContext ctx;
	
	protected ApplicationContext getContext () {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		}
		return ctx;
	}
	
}
