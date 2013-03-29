package fr.afcepf.atod17.vinsurvin.services.implementations;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCompte;

public class ServiceCompteImpl implements IServiceCompte{

	public IDaoCompte daoCompte;
	
	public ServiceCompteImpl (){
	
	}

	@Override
	public CompteClient addCompteClient(CompteClient compte) {
		return daoCompte.setCompte(compte);
	}

	public IDaoCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	
}
