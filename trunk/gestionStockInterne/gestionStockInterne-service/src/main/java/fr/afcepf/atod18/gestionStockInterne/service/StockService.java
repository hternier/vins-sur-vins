package fr.afcepf.atod18.gestionStockInterne.service;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;

public interface StockService {
	
	/**
	 * Permet de récupérer le stock restant d'un produit.
	 * @param idProduit L'id du produit dont le stock est à récupérer.
	 * @return La quantité en stock.
	 */
	public ProduitStock fillProduitStock(ProduitStock paramProduit);
	
	/**
	 * Permet de récupérer le stock restant d'un produit.
	 * @param paramIdProduit L'id du produit dont le stock est à récupérer.
	 * @return La quantité en stock.
	 */
	public Integer getStock(Integer paramIdProduit);

}
