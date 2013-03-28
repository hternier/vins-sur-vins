package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Prix;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceProduit;

public class ServiceProduitImpl implements IServiceProduit {
	
	private IDaoProduit daoProduit;
	
	public ServiceProduitImpl() {
		
	}
	
	public List<Produit> getAllProduit(boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllEnStock();
		} else {
			listeRetour = daoProduit.getAll();
		}
		return listeRetour;
	}
	
	public Produit getProduit(Produit produit) {
		return daoProduit.getProduit(produit);
	}
	
	public Double getPrixActuel(Produit paramProduit) {
		for (Prix prix : paramProduit.getPrix()) {
			if(prix.getDateDebut().before(new Date()) | prix.getDateFin().after(new Date())) {
				return prix.getValeurHT();
			}
		}
		return null;
	}
	

	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	public void setDaoProduit(IDaoProduit daoProduit) {
		this.daoProduit = daoProduit;
	}
	
}
