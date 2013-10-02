package fr.afcepf.atod18.gestionFournisseur.service;

public interface CommandeService {
	
	/** Méthode qui permet de passer Commande.
	 * Retourne true si validé.
	 * Retourne false si refuse.
	 * @param idProduit
	 * @return true ou false.
	 */
	public Boolean passerCommande(Integer idProduit);
	public String nomFournisseur(Integer idProduit);

}
