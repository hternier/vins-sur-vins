package fr.afcepf.atod17.vinsurvin.services.interfaces;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteAbstrait;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;

/**
 * @author Nassim 29/03/2013
 * Interface de gestion des compte utilisateurs et systeme.
 *
 */
public interface IServiceCompte {

	public CompteClient addCompteClient(CompteClient compte);
	public CompteClient getCompteClient(CompteClient compte);
	public CompteClient authentificationFO (CompteAbstrait paramCompte);

	
	/** 
	 * Methode pour authentifier un gestionnaire de site
	 * @param paramCompteSysteme : objet compte systeme
	 * **/
	public CompteSysteme authentificationBO(CompteSysteme paramCompteSysteme);
	
}
