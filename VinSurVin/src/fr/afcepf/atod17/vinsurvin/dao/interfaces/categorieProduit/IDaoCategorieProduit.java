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
	List<Produit> getAllProduitsParCategorie(Integer paramValeurCategorie);
//	public List<Produit> getAllProduitsParCategorie(Categorie paramValeurCategorie);
//	List<Produit> getAllProduitsParCategorie(String paramValeurCategorie);
}
