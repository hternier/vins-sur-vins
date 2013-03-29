package fr.afcepf.atod17.vinsurvin.services.interfaces;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public interface IServiceProduit {

	/**
	 * <b>getAllProduit</b> Méthode pour obtenir tous les produits.<br />
	 * 
	 * @param enStock : boolean, Si vrai, ne seront retournés que les Produits en stock
	 * @return
	 */
	public List<Produit> getAllProduit(boolean enStock);
	public Produit getProduit(Produit produit);
	public Double getPrixActuelHT(Produit paramProduit);
	
	/**
	 * <b>getAllRegion</b> Méthode pour obtenir toutes les régions de vin.
	 * 
	 * @param enStock : boolean, Si vrai, ne seront retournés que les region dont les vins sont en stock
	 * @return
	 */
	public List<String> getAllRegion(boolean enStock);
	
	/**
	 * <b>getAllProduitParNom</b> Méthode pour rechercher des produits par nom.
	 * @param paramNom : la chaîne de recherche
	 * @param enStock : boolean, si vrai, ne seront retrournés que des produits en stock.
	 * @return
	 */
	public List<Produit> getAllProduitParNom(String paramNom, boolean enStock);
	
	public List<Produit> getAllProduitParPrix (double prixMin, double prixMax, boolean enStock);
	
	public List<Produit> getAllProduitParPrixEtNom (double prixMin, double prixMax, boolean enStock, String paramNom);
	public Double getPrixActuelTTC(Produit paramProduit);
	
}
