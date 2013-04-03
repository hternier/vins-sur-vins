package fr.afcepf.atod17.vinsurvin.dao.interfaces.compte;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;

public interface IDaoCompte {

	public CompteClient setCompte(CompteClient compte);

	public CompteClient getCompteClient(CompteClient paramCompteClient);

	public CompteSysteme authentificationBO(String login, String mdp);

	public CompteClient authentificationFO(String paramMail, String paramMdp);
	
	public List<Ville> getVilleParCP(String cp);
}
