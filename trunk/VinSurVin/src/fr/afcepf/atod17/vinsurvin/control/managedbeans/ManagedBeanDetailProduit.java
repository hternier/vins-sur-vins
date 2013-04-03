package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import fr.afcepf.atod17.vinsurvin.control.entities.ProduitVueDetail;

public class ManagedBeanDetailProduit extends AbstractManagedBean {

	private ProduitVueDetail produit;
	
	public ManagedBeanDetailProduit() {
		
	}

	public ProduitVueDetail getProduit() {
		return produit;
	}

	public void setProduit(ProduitVueDetail produit) {
		this.produit = produit;
	}
	
}
