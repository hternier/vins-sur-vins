package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.control.managedbeans.AbstractManagedBean;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class VinVueRecherche extends AbstractManagedBean {
	
	private Vin vin;
	private int quantite = 1;
	
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@Deprecated
	public int getStock() {
		return this.vin.getStock();
	}

}
