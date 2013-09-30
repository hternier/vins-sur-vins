package fr.afcepf.atod18.gestionStockInterne.serveur;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;
import fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService;
import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.service.StockService;

@WebService(endpointInterface = "fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService")
public class StockInterneServiceImpl implements StockInterneService {

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

		// Création de ProduitStockDto et conversion de ProduitStock en
		// ProduitStockDto
		ProduitStockDto paramProduit = new ProduitStockDto(paramIdProduit,
				produitStockBean.getQuantiteStock(),
				produitStockBean.getQuantiteMinimal());

		return paramProduit;
	}

	@Override
	public ProduitStockDto incrementeStock(Integer paramIdProduit,
			Integer paramQuantiteAjouter) {

		// Incrémentation du stock
		ProduitStock produitStockBean = stockService.incrementeStock(
				paramIdProduit, paramQuantiteAjouter);

		// Création de ProduitStockDto et conversion de produitStockBean en
		// ProduitStockDto
		ProduitStockDto produitStockDto = new ProduitStockDto(paramIdProduit,
				produitStockBean.getQuantiteStock(),
				produitStockBean.getQuantiteMinimal());

		return produitStockDto;
	}

	@Override
	public ProduitStockDto decrementeStock(Integer paramIdProduit,
			Integer paramQuantiteRetirer) {

		// Décrémentation du stock
		ProduitStock produitStockBean = stockService.decrementeStock(
				paramIdProduit, paramQuantiteRetirer);

		// Création de ProduitStockDto et conversion de produitStockBean en
		// ProduitStockDto
		ProduitStockDto produitStockDto = new ProduitStockDto(paramIdProduit,
				produitStockBean.getQuantiteStock(),
				produitStockBean.getQuantiteMinimal());

		return produitStockDto;
	}

}