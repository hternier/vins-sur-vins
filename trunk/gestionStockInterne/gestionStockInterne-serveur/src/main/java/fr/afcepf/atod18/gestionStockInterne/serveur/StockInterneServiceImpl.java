package fr.afcepf.atod18.gestionStockInterne.serveur;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;
import fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService;
import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.service.StockService;

@WebService(endpointInterface = "fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService")
public class StockInterneServiceImpl implements StockInterneService {
	
	private static Logger logger = Logger.getLogger(StockInterneServiceImpl.class);

	@Autowired
	private StockService stockService;

	@Override
	public ProduitStockDto getStockFromProduitStockDto(
			ProduitStockDto paramProduit) {

		return getStock(paramProduit.getId());
	}

	@Override
	public ProduitStockDto getStock(Integer paramIdProduit) {

		// Création de ProduitStock avec l'id voulu
		ProduitStock produitStockBean = new ProduitStock(paramIdProduit);

		// Récupération du stock et quantité mini dans ProduitStock
		produitStockBean = stockService.getStock(produitStockBean);

		return produitStockBean.toDto();
	}

	@Override
	public ProduitStockDto incrementeStock(Integer paramIdProduit,
			Integer paramQuantiteAjouter) {

		// Incrémentation du stock
		ProduitStock produitStockBean = stockService.incrementeStock(
				paramIdProduit, paramQuantiteAjouter);

		return produitStockBean.toDto();
	}

	@Override
	public ProduitStockDto decrementeStock(Integer paramIdProduit,
			Integer paramQuantiteRetirer) {
		
		logger.info("Entrée dans le webService gestionStockInterne");
		
		// Décrémentation du stock
		ProduitStock produitStockBean = stockService.decrementeStock(
				paramIdProduit, paramQuantiteRetirer);

		logger.info("Sortie du webService gestionStockInterne");

		return produitStockBean.toDto();
	}

}
