package fr.afcepf.atod18.controleDeStock.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
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
	
	private static Logger logger = Logger.getLogger(StockServiceImpl.class);
	
	@Autowired
	private StockInterneService stockInterneService;
	
	@Autowired
	private CommandesFournisseursService commandesFournisseursService;

	@Override
	public boolean passerCommande(CommandeControleStock commande) {
		
		logger.info("Passage de commande : " + commande.getProduits().size() + "produits.");
		
		boolean confirmationCommandeRetour = true;
		
		Set<Integer> produitsACommanderId = new HashSet<Integer>(commande.getProduits().size());
		
		for (ProduitControleStock produitCommande : commande.getProduits()) {
			
			Integer idProduit = produitCommande.getId();
			
			ProduitStockDto produitStock = stockInterneService.getStock(idProduit);
			
			if (produitStock.getQuantiteStock() < produitCommande.getQuantite()) {
				logger.error("Stock insuffisant pour le produit : " + idProduit);
				confirmationCommandeRetour = false;
				break;
			}
			
			logger.info("Décrément du stock pour le produit : " + idProduit);
			produitStock = stockInterneService.decrementeStock(idProduit, produitCommande.getQuantite());
			
			if (produitStock.getQuantiteMinimale() > produitStock.getQuantiteStock()) {
				logger.info("Seuil minimal franchis, ajout à la liste de commande : produit : " + idProduit);
				produitsACommanderId.add(idProduit);
			}
			
		}
		
		for (Integer idProduit : produitsACommanderId) {
			if (commandesFournisseursService.passerCommande(idProduit)) {
				logger.info("Commande passée pour le produit : " + idProduit);
			} else {
				logger.error("Erreur lors de l'envoie de la commande du produit : " + idProduit);
			}
		}
		
		return confirmationCommandeRetour;
	}

	@Override
	public int getStockActuel(ProduitControleStock produit) {
		ProduitStockDto produitStock = stockInterneService.getStock(produit.getId());
		return produitStock.getQuantiteStock().intValue();
	}

	@Override
	public boolean verifierDisponibilite(ProduitControleStock produit,
			int quantiteStock) {
		ProduitStockDto produitStock = stockInterneService.getStock(produit.getId());
		
		return produitStock.getQuantiteStock().intValue() >= quantiteStock;
	}
	
	

}
