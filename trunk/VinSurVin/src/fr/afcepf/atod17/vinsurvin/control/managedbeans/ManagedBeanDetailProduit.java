package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class ManagedBeanDetailProduit extends AbstractManagedBean {

	private Produit produit;
	
	public ManagedBeanDetailProduit() {
		
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
}
