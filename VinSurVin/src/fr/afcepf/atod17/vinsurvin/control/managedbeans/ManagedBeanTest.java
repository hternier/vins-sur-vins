package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanTest extends AbstractManagedBean {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	private Produit produit = new Vin();
	private Produit produit2 = new Vin();
	
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
	
	public void setProduit(Produit produit) {
        produit.setId(1);
        this.produit = getContext().getBean(ServiceProduitImpl.class).getProduit(produit);
    }
	
	public Produit getProduit() {
	    produit.setId(1);
	    this.produit = getContext().getBean(ServiceProduitImpl.class).getProduit(produit);
	    return produit;
    }
	
	public Produit getProduit2() {
        produit2.setId(2);
        this.produit2 = getContext().getBean(ServiceProduitImpl.class).getProduit(produit2);
        return produit2;
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
