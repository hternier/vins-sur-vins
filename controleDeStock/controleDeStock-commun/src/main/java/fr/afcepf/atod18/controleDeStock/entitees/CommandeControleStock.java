package fr.afcepf.atod18.controleDeStock.entitees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandeControleStock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<ProduitControleStock> produits;
	
	public CommandeControleStock() {
		produits = new ArrayList<ProduitControleStock>(10);
	}

	public List<ProduitControleStock> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitControleStock> produits) {
		this.produits = produits;
	}
	
}
