package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;

public class ManagedBeanCreerCompte extends AbstractManagedBean {

	private CompteClient compteclient = new CompteClient();
	public String creerCompte() {
		this.compteclient= getContext().getBean(ServiceCompteImpl.class).addCompteClient(compteclient);
		System.out.println("c fait!");
		return "Success";
	}
}
