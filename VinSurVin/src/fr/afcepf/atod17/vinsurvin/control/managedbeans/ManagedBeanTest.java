package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod17.vinsurvin.dao.DaoTest;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class ManagedBeanTest {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	
	public String testAction() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
		
		this.listeProduit = ctx.getBean("testBean", DaoTest.class).getAll();
		
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

}
