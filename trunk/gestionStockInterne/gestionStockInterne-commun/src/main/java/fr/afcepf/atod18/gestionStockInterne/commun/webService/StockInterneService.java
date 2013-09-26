package fr.afcepf.atod18.gestionStockInterne.commun.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStock;


@WebService
public interface StockInterneService {

	@WebMethod(operationName="getStock")
	public ProduitStock getStock(ProduitStock paramProduitStock);
	
	@WebMethod(operationName="ping")
	public String ping(String paramString);
}
