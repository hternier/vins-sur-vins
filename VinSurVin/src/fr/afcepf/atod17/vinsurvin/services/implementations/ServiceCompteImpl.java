package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteAbstrait;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCompte;

public class ServiceCompteImpl implements IServiceCompte {

	public IDaoCompte daoCompte;

	public ServiceCompteImpl() {

	}

	@Override
	public CompteClient addCompteClient(CompteClient compte) {
		return daoCompte.setCompte(compte);
	}

	@Override
	public List<Ville> getVilleParCP(String cp) {
		return daoCompte.getVilleParCP(cp);
	}

	@Override
	public CompteClient getCompteClient(CompteClient paramCompte) {
		return daoCompte.getCompteClient(paramCompte);
	}

	public IDaoCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	@Override
	public CompteSysteme authentificationBO(CompteSysteme paramCompteSysteme) {
		return daoCompte.authentificationBO(paramCompteSysteme.getMail(),
				paramCompteSysteme.getMdp());
	}

	@Override
	public CompteClient authentificationFO(CompteAbstrait paramCompte) {
		return daoCompte.authentificationFO(paramCompte.getMail(),
				paramCompte.getMdp());
	}

	@Override
	public boolean testEmail(String mail) {
		boolean retour = false;
		if (daoCompte.testEmail(mail) == 0) {
			retour = true;
		}
		return retour;
	}

}
