package fr.afcepf.atod17.vinsurvin.services;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class ServiceProduit {
	
	private IDaoProduit daoProduit;
	
	public ServiceProduit() {
		
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
	

	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	public void setDaoProduit(IDaoProduit daoProduit) {
		this.daoProduit = daoProduit;
	}
	
}
