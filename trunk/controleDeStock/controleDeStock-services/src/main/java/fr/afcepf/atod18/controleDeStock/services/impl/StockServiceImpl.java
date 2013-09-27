package fr.afcepf.atod18.controleDeStock.services.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.services.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	

	@Override
	public boolean passerCommande(CommandeControleStock commande) {
		return false;
	}

}
