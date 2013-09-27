package fr.afcepf.atod18.controleDeStock.services;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;

public interface StockService {
	
	public boolean passerCommande(CommandeControleStock commande);

}
