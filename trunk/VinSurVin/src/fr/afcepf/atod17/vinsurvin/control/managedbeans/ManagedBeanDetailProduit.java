package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import fr.afcepf.atod17.vinsurvin.control.entities.ProduitVueDetail;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;

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
	
	public int getImageRowSpan() {
		int retour = 1;
		String typeProduit = this.produit.getProduit().getClass().getSimpleName();
		if (typeProduit.equals(Vin.class.getSimpleName())) {
			retour = 6;
		} else if (typeProduit.equals(Spiritueux.class.getSimpleName())) {
			retour = 5;
		} else if (typeProduit.equals(Accessoire.class.getSimpleName())) {
			retour = 4;
		}
		return retour;
	}
	
}
