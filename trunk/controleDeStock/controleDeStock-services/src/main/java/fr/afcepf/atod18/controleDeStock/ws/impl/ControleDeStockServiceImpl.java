package fr.afcepf.atod18.controleDeStock.ws.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;
import fr.afcepf.atod18.controleDeStock.services.StockService;
import fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService;

@WebService(endpointInterface = "fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService")
public class ControleDeStockServiceImpl implements ControleDeStockService {

	@Autowired
	private StockService stockService;
	
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
		return stockService.passerCommande(commande);
	}

	@Override
	public String ping(String string) {
		return "pong : " + string;
	}

}
