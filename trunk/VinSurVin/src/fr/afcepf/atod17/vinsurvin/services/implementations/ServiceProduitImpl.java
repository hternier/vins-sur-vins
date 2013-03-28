package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
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
	

	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	public void setDaoProduit(IDaoProduit daoProduit) {
		this.daoProduit = daoProduit;
	}
	
}
