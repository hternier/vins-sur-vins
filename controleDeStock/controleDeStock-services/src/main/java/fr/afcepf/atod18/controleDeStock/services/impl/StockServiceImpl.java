package fr.afcepf.atod18.controleDeStock.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;
import fr.afcepf.atod18.controleDeStock.services.StockService;
import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;
import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;
import fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockInterneService stockInterneService;
	
	@Autowired
	private CommandesFournisseursService commandesFournisseursService;

	@Override
	public boolean passerCommande(CommandeControleStock commande) {
		
		boolean confirmationCommandeRetour = true;
		
		Set<Integer> produitsACommanderId = new HashSet<Integer>(commande.getProduits().size());
		
		for (ProduitControleStock produitCommande : commande.getProduits()) {
			
			Integer idProduit = produitCommande.getId();
			
			ProduitStockDto produitStock = stockInterneService.getStock(idProduit);
			
			if (produitStock.getQuantiteStock() < produitCommande.getQuantite()) {
				confirmationCommandeRetour = false;
				break;
			}
			
			produitStock = stockInterneService.decrementeStock(idProduit, produitCommande.getQuantite());
			
			if (produitStock.getQuantiteMinimale() > produitStock.getQuantiteStock()) {
				produitsACommanderId.add(produitCommande.getId());
			}
			
		}
		
		for (Integer idProduit : produitsACommanderId) {
			commandesFournisseursService.passerCommande(idProduit);
		}
		
		return confirmationCommandeRetour;
	}

}
