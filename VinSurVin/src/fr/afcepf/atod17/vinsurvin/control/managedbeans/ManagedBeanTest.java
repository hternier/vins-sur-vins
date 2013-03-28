package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.ServiceCatalogue;

public class ManagedBeanTest {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	private ApplicationContext ctx;
	
	public String testAction() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		this.listeProduit = ctx.getBean("serviceCatalogue", ServiceCatalogue.class).getAllProduit(false);
		
		return "";
	}
	
	public String testActionEnStock() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		this.listeProduit = ctx.getBean("serviceCatalogue", ServiceCatalogue.class).getAllProduit(true);
		
		return "";
	}

	public List<Produit> getListeProduit() {
		return this.listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	public int getListeProduitLength() {
		return this.listeProduit.size();
	}

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

}
