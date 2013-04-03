package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import org.springframework.context.ApplicationContext;

import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public abstract class AbstractManagedBean {
	
	protected ApplicationContext getContext () {
		return VinSurVinContext.getSpringContext();
	}
	
}
