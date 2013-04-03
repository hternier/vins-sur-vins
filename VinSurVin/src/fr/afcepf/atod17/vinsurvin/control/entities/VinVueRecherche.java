package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class VinVueRecherche {
	
	private Vin vin;
	
	public VinVueRecherche(Vin vin) {
		this.vin = vin;
	}
	
	public String getLibelle() {
		return vin.getLibelle();
	}
	
	public double getPrix() {
		return VinSurVinContext.getSpringContext().getBean(ServiceProduitImpl.class).getPrixActuelTTC(vin);
	}
	
	public String getImage() {
		String retour = "../resources/images/produits/noimage.jpg";
		if (vin.getImage() != null && !vin.getImage().isEmpty()) {
			retour = "../resources/images/produits/" + vin.getImage(); 
		}
		return retour;
	}
	
	public String getMillesime() {
		return vin.getMillesime();
	}
	
	public int getId() {
		return vin.getId();
	}

	public Vin getVin() {
		return vin;
	}

	public void setVin(Vin vin) {
		this.vin = vin;
	}

}