package fr.afcepf.atod18.controleDeStock.services;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;

public interface StockService {
	
	public boolean passerCommande(CommandeControleStock commande);
	
	public int getStockActuel(ProduitControleStock produit);
	
	public boolean verifierDisponibilite(ProduitControleStock produit, int quantiteStock);

}
