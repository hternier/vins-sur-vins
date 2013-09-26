package fr.afcepf.atod18.gestionStockInterne.commun.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface StockInterneService {

	@WebMethod(operationName="getStock")
	public Integer getStock(Integer paramIdProduit);
	
	@WebMethod(operationName="ping")
	public String ping(String paramString);
}
