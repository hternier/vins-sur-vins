package fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS;

import javax.jws.WebService;

@WebService
public interface CommandesFournisseursService {
	
	/**Méthode permettant de passer une commande.**/
	public Boolean passerCommande(Integer idProduit);	
}
