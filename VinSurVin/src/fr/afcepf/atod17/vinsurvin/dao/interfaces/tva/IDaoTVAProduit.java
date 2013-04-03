/**
 * 
 */
package fr.afcepf.atod17.vinsurvin.dao.interfaces.tva;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.TVA;

/**
 * @author Cindy 02/04/2013
 *
 */
public interface IDaoTVAProduit {
	public List<TVA> getAllTauxTVA();
}
