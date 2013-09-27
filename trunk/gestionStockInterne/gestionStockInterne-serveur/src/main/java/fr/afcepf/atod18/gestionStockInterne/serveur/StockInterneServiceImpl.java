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
	public ProduitStockDto getStockFromProduitStockDto(ProduitStockDto paramProduit) {

		return getStock(paramProduit.getId());
	}

	@Override
	public ProduitStockDto getStock(Integer paramIdProduit) {

		// Création de ProduitStock avec l'id voulu
		ProduitStock produitStockBean = new ProduitStock(paramIdProduit);

		// Récupération du stock et quantité mini dans ProduitStock
		stockService.fillProduitStock(produitStockBean);

		// Création de ProduitStockDto et conversion de ProduitStock en
		// ProduitStockDto
		ProduitStockDto paramProduit = new ProduitStockDto(paramIdProduit,
				produitStockBean.getQuantiteStock(),
				produitStockBean.getQuantiteMinimal());

		return paramProduit;
	}

	@Override
	public String ping(String paramString) {
		paramString = "PONG : " + paramString;
		return paramString;
	}

}
