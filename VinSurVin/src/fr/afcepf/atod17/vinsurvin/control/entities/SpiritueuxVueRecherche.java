package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.control.managedbeans.AbstractManagedBean;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class SpiritueuxVueRecherche extends AbstractManagedBean {
	
	private Spiritueux spiritueux;
	private int quantite = 1;
	
	public SpiritueuxVueRecherche(Spiritueux spiritueux) {
		this.spiritueux = spiritueux;
	}
	
	public String getLibelle() {
		return this.spiritueux.getLibelle();
	}
	
	public String getImage() {
		String retour = "../resources/images/produits/noimage.jpg";
		if (spiritueux.getImage() != null && !spiritueux.getImage().isEmpty()) {
			retour = "../resources/images/produits/" + spiritueux.getImage(); 
		}
		return retour;
	}
	
	public String getMillesime() {
		return spiritueux.getMillesime();
	}
	
	public double getPrix() {
		return VinSurVinContext.getSpringContext().getBean(ServiceProduitImpl.class).getPrixActuelTTC(spiritueux);
	}
	
	public int getId() {
		return spiritueux.getId();
	}

	public Spiritueux getSpiritueux() {
		return spiritueux;
	}

	public void setSpiritueux(Spiritueux spiritueux) {
		this.spiritueux = spiritueux;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@Deprecated
	public int getStock() {
		return this.spiritueux.getStock();
	}

}
