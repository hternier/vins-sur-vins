package fr.afcepf.atod17.vinsurvin.services.interfaces;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteAbstrait;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;

/**
 * @author Nassim 29/03/2013 Interface de gestion des compte utilisateurs et
 *         systeme.
 * 
 */
public interface IServiceCompte {

	public CompteClient addCompteClient(CompteClient compte);

	public CompteClient getCompteClient(CompteClient compte);
	
	public List<Ville> getVilleParCP(String cp);

	public Long testEmail(String mail);
	/**
	 * Methode pour authentifier un utilisateur de site
	 * 
	 * @param paramCompteSysteme
	 *            : objet compte systeme
	 * **/
	public CompteClient authentificationFO(CompteAbstrait paramCompte);

	/**
	 * Methode pour authentifier un gestionnaire de site
	 * 
	 * @param paramCompteSysteme
	 *            : objet compte systeme
	 * **/
	public CompteSysteme authentificationBO(CompteSysteme paramCompteSysteme);

}
