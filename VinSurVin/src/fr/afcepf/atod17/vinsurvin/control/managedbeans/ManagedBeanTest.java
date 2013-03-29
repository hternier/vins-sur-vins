package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanTest extends AbstractManagedBean {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	
	public String testAction() {
		this.listeProduit = getContext().getBean("serviceProduit", ServiceProduitImpl.class).getAllProduit(false);
		
		return "";
	}
	
	public String testActionEnStock() {
		this.listeProduit = getContext().getBean("serviceProduit", ServiceProduitImpl.class).getAllProduit(true);
		
		return "";
	}

	public List<Produit> getListeProduit() {
		return this.listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	public int getListeProduitLength() {
		int retour = 0;
		if (listeProduit !=null) {
			retour = listeProduit.size();
		}
		return retour;
	}

}
