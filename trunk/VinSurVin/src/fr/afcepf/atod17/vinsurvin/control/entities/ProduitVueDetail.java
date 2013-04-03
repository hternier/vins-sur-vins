package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class ProduitVueDetail {
	
	private Produit produit;
	private int quantite = 1;
	
	public ProduitVueDetail(Produit produit) {
		this.produit = produit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getImage() {
		String retour = "../resources/images/produits/noimage.jpg";
		if (produit.getImage() != null && !produit.getImage().isEmpty()) {
			retour = "../resources/images/produits/" + produit.getImage(); 
		}
		return retour;
	}
	
	public String getLibelle() {
		return this.produit.getLibelle();
	}
	
	public String getDescription() {
		return this.produit.getDescription();
	}
	
	public String getCategorie() {
		return this.produit.getCategorie().getValeur();
	}
	
	public double getPrixHT() {
		return VinSurVinContext.getSpringContext().getBean(ServiceProduitImpl.class).getPrixActuelHT(produit);
	}
	
	public double getPrixTTC() {
		return VinSurVinContext.getSpringContext().getBean(ServiceProduitImpl.class).getPrixActuelTTC(produit);
	}
	
	public boolean getProduitIsVin() {
		return this.produit.getClass().getSimpleName().equals(Vin.class.getSimpleName());
	}
	
	public String getRegion() {
		return ((Vin) this.produit).getRegion();
	}
	
	public int getStock() {
		return this.produit.getStock();
	}
	
}
