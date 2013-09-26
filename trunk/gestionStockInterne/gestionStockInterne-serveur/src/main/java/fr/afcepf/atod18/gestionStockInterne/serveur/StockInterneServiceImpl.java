package fr.afcepf.atod18.gestionStockInterne.serveur;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;
import fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService;
import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.service.StockService;

@WebService(endpointInterface="fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService")
public class StockInterneServiceImpl implements StockInterneService {

	@Autowired
	private StockService stockService;
	
	@Override
	public void fillProduitStock(ProduitStockDto paramProduit) {
		
		ProduitStock produitStockBean = new ProduitStock();
		produitStockBean.setId(paramProduit.getId());
		
		produitStockBean = stockService.fillProduitStock(produitStockBean);
		
		paramProduit.setQuantiteStock(produitStockBean.getQuantiteStock());
		paramProduit.setQuantiteMinimal(produitStockBean.getQuantiteMinimal());
	}
	
	@Override
	public Integer getStock(Integer paramIdProduit) {
		
		return stockService.getStock(paramIdProduit);
	}

	@Override
	public String ping(String paramString) {
		paramString = "PONG : " + paramString;
		return paramString;
	}


}
