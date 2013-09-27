package fr.afcepf.atod18.gestionStockInterne.service;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;

public interface StockService {
	
	/**
	 * Remplit le produit avec le stock restant du produit et la quantité minimale.
	 * @param idProduit Le produit dont le stock et la quantité minimale sont à récupérer.
	 */
	public ProduitStock getStock(ProduitStock paramProduit);
	
	/**
	 * Récupère le stock restant d'un produit.
	 * @param paramIdProduit L'id du produit dont le stock est à récupérer.
	 * @return La quantité en stock.
	 */
	public ProduitStock getStock(Integer paramIdProduit);

}
