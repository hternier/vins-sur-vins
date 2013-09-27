package fr.afcepf.atod18.controleDeStock.ws.impl;

import javax.jws.WebService;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;
import fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService;

@WebService(endpointInterface = "fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService")
public class ControleDeStockServiceImpl implements ControleDeStockService {

	@Override
	public int getStockActuel(ProduitControleStock produit) {
		int retour = 5;
		
		if (produit == null) {
			retour = 0;
		}
		
		return retour;
	}

	@Override
	public boolean verifierDisponibilite(ProduitControleStock produit, int quantiteStock) {
		if (produit == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean passerCommande(CommandeControleStock commande) {
		if (commande != null) {
			return true;
		} else {
			return false;
		}
	}

}
