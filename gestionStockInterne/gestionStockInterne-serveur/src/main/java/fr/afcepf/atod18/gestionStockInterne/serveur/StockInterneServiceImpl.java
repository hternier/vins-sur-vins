package fr.afcepf.atod18.gestionStockInterne.serveur;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService;
import fr.afcepf.atod18.gestionStockInterne.service.StockService;

@WebService(endpointInterface="fr.afcepf.atod18.gestionStockInterne.commun.webService.StockInterneService")
public class StockInterneServiceImpl implements StockInterneService {

	@Autowired
	private StockService stockService;
	
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
