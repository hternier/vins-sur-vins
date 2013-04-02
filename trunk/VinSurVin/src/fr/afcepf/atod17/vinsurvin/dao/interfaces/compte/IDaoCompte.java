package fr.afcepf.atod17.vinsurvin.dao.interfaces.compte;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;

public interface IDaoCompte {
	
	public CompteClient setCompte(CompteClient compte);
	  public CompteClient getCompteClient(CompteClient paramCompteClient);
	
	public CompteSysteme authentificationBO(String login, String mdp);
    public CompteClient authentificationFO(String paramMail, String paramMdp);
}
