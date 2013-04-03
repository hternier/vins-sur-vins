/**
 * 
 */
package fr.afcepf.atod17.vinsurvin.dao.interfaces.categorieProduit;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

/**
 * @author Cindy 02/04/2013
 * 
 */
public interface IDaoCategorieProduit {
	public List<Categorie> getAllCategoriesAsString();

	/**
	 * Méthode de recherche de tous les produits d'une catégorie
	 **/
	List<Produit> getAllProduitsParCategorie(Integer paramValeurCategorie);

	/**
	 * Méthode de recherche de tous les produits d'une catégorie + recherche
	 * textuelle
	 **/
	public List<Produit> getAllProduitsParCategorieEtTexte(Integer paramCat,
			String paramText);
}
