package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class AccessoireVueRecherche {
	
	private Accessoire accessoire;
	private int quantite = 1;
	
	public AccessoireVueRecherche(Accessoire accessoire) {
		this.accessoire = accessoire;
	}

	public Accessoire getAccessoire() {
		return accessoire;
	}

	public void setAccessoire(Accessoire accessoire) {
		this.accessoire = accessoire;
	}
	
	public String getLibelle() {
		return accessoire.getLibelle();
	}
	
	public String getImage() {
		String retour = "../resources/images/produits/noimage.jpg";
		if (accessoire.getImage() != null && !accessoire.getImage().isEmpty()) {
			retour = "../resources/images/produits/" + accessoire.getImage(); 
		}
		return retour;
	}
	
	public double getPrix() {
		return VinSurVinContext.getSpringContext().getBean(ServiceProduitImpl.class).getPrixActuelTTC(accessoire);
	}
	
	public int getId() {
		return accessoire.getId();
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public int getStock() {
		return this.accessoire.getStock();
	}
	
}
