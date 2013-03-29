package fr.afcepf.atod17.vinsurvin.dao.interfaces.compte;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;

public interface IDaoCompte {
	
	public CompteClient setCompte(CompteClient compte);
    public CompteClient getCompteClient(CompteClient paramCompteClient);
}
