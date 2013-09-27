package fr.afcepf.atod18.gestionStockInterne.commun.webService;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;

@WebService
public interface StockInterneService {
	
	/**
	 * Permet de récupérer le stock restant d'un produit et la quantitée minimun.
	 * @param paramProduit L'objet ProduitStockDto contenant l'id du produit voulu.
	 * @return L'objet ProduitStockDto contenant le stock restant d'un produit et la quantitée minimun.
	 */
	@WebMethod(operationName="getStockFromProduitStockDto")
	public ProduitStockDto getStockFromProduitStockDto(ProduitStockDto paramProduit);

	/**
	 * Permet de récupérer le stock restant d'un produit et la quantitée minimun.
	 * @param paramIdProduit L'id du produit voulu.
	 * @return L'objet ProduitStockDto contenant le stock restant d'un produit et la quantitée minimun.
	 */
	@WebMethod(operationName="getStock")
	public ProduitStockDto getStock(Integer paramIdProduit);
	
	/**
	 * Permet de tester le fonctionnement du web service avec un ping.
	 * @param paramString String en entrée.
	 * @return String de retour.
	 */
	@WebMethod(operationName="ping")
	public String ping(String paramString);
}
