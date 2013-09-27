package fr.afcepf.atod18.gestionStockInterne.service;

import javax.jws.WebParam;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;

public interface StockService {
	
	/**
	 * Remplit le produit avec le stock restant du produit et la quantité minimale.
	 * @param idProduit Le produit dont le stock et la quantité minimale sont à récupérer.
	 */
	public ProduitStock getStock(@WebParam(name = "produitStock")ProduitStock paramProduit);
	
	/**
	 * Récupère le stock restant d'un produit.
	 * @param paramIdProduit L'id du produit dont le stock est à récupérer.
	 * @return La quantité en stock.
	 */
	public ProduitStock getStock(@WebParam(name = "idProduit")Integer paramIdProduit);
	
	/**
	 * Incrémente le stock pour l'id du produit en parametre.
	 * @param paramIdProduit Produit à incrémenter.
	 * @param paramQuantiteAjouter Quantité à ajouter au stock.
	 * @return Le ProduitStock avec la nouvelle valeur du stock.
	 */
	public ProduitStock incrementeStock(@WebParam(name = "idProduit")Integer paramIdProduit,
			@WebParam(name = "quantiteAjouter")Integer paramQuantiteAjouter);
	
	/**
	 * Décrémente le stock pour l'id du produit en parametre.
	 * @param paramIdProduit Produit à décrémenter.
	 * @param paramQuantiteRetirer Quantité à retirer au stock.
	 * @return Le ProduitStock avec la nouvelle valeur du stock.
	 */
	public ProduitStock decrementeStock(@WebParam(name = "idProduit")Integer paramIdProduit,
			@WebParam(name = "quantiteRetirer")Integer paramQuantiteRetirer);
	
}
