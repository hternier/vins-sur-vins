package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.control.managedbeans.AbstractManagedBean;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceStockImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class ProduitVueDetail extends AbstractManagedBean {
	
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
	
	public boolean getIsVin() {
		return this.produit.getClass().getSimpleName().equals(Vin.class.getSimpleName());
	}
	
	public boolean getIsSpiritueux() {
		return this.produit.getClass().getSimpleName().equals(Spiritueux.class.getSimpleName());
	}
	
	public boolean getIsAccessoire() {
		return this.produit.getClass().getSimpleName().equals(Accessoire.class.getSimpleName());
	}
	
	public String getRegionVin() {
		return ((Vin) this.produit).getRegion();
	}
	
	public int getStock() {
		//return this.produit.getStock();
		return getContext().getBean(ServiceStockImpl.class).getStockActuel(this.produit);
	}
	
	public double getTVA() {
		return this.produit.getTva().getValeur();
	}
	
	public String getAppelationVin() {
		return ((Vin) this.produit).getAppelation();
	}
	
	public String getMillesimeVin() {
		return ((Vin) this.produit).getMillesime();
	}
	
	public String getPaysVin() {
		return ((Vin) this.produit).getPays();
	}
	
	public int getContenanceVin() {
		return ((Vin) this.produit).getContenance();
	}
	
	public String getDegresVin() {
		return ((Vin) this.produit).getDegres();
	}
	
	public String getAppellationSpiritueux() {
		return ((Spiritueux) this.produit).getAppellation();
	}
	
	public int getContenanceSpiritueux() {
		return ((Spiritueux) this.produit).getContenance();
	}
	
	public String getDegresSpiritueux() {
		return ((Spiritueux) this.produit).getDegres();
	}
	
	public String getMillesimeSpiritueux() {
		return ((Spiritueux) this.produit).getMillesime();
	}
	
	public String getMarque() {
		return ((Accessoire) this.produit).getMarque();
	}
	
	public int getPoids() {
		return ((Accessoire) this.produit).getPoids();
	}
	
}
