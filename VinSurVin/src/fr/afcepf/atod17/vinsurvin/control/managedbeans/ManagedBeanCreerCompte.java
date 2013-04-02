package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Adresse;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;

public class ManagedBeanCreerCompte extends AbstractManagedBean {

	private CompteClient compteClient = new CompteClient();

	{
		compteClient.setAdresseFacturation(new Adresse());
	}

	public String creerCompte() {
		
		this.compteClient = getContext().getBean(ServiceCompteImpl.class).addCompteClient(compteClient);
		return "Success";
	}

	public CompteClient getCompteClient() {
		return compteClient;
	}

	public void setCompteClient(CompteClient compteClient) {
		this.compteClient = compteClient;
	}
}
