package fr.afcepf.atod18.gestionStockInterne.commun.webService;

import javax.jws.WebMethod;
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
	 * Incrémente le stock pour l'id du produit en parametre.
	 * @param paramIdProduit Produit à incrémenter.
	 * @param paramQuantiteAjouter Quantité à ajouter au stock.
	 * @return Le ProduitStockDto avec la nouvelle valeur du stock.
	 */
	@WebMethod(operationName="incrementeStock")
	public ProduitStockDto incrementeStock(Integer paramIdProduit, Integer paramQuantiteAjouter);
	
	/**
	 * Décrémente le stock pour l'id du produit en parametre.
	 * @param paramIdProduit Produit à décrémenter.
	 * @param paramQuantiteRetirer Quantité à retirer au stock.
	 * @return Le ProduitStockDto avec la nouvelle valeur du stock.
	 */
	@WebMethod(operationName="decrementeStock")
	public ProduitStockDto decrementeStock(Integer paramIdProduit, Integer paramQuantiteRetirer);
}
