package fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS;

import javax.jws.WebService;

@WebService
public interface CommandesFournisseursService {

	/** Méthode de test de la connexion au webservice. **/
	public String ping (String pong);
	
	/** Méthode de **/
	public Integer getStock (Integer idProduitStock);
}
