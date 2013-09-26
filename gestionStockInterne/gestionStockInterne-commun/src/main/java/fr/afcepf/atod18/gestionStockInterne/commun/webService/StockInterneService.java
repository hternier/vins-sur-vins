package fr.afcepf.atod18.gestionStockInterne.commun.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;

@WebService
public interface StockInterneService {
	
	@WebMethod(operationName="fillProduitStock")
	public ProduitStockDto fillProduitStock(ProduitStockDto paramProduit);

	@WebMethod(operationName="getStock")
	public Integer getStock(Integer paramIdProduit);
	
	@WebMethod(operationName="ping")
	public String ping(String paramString);
}
