package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;

public class ManagedBeanLoginBackOffice extends AbstractManagedBean {
	private String login;
	private String mdp;

	public ManagedBeanLoginBackOffice() {
	}

	public String authentificationBO() {
		System.out.println("appel  MBLoginBO");
		ServiceCompteImpl serviceCompteSysteme = getContext().getBean(
				ServiceCompteImpl.class);
		System.out.println("dans  MBLoginBO  : login saisie par utilisateur  :"
				+ login.trim() + " mdp saisie par utilisateur: " + mdp.trim());
		CompteSysteme compteSysteme = new CompteSysteme();
		compteSysteme.setMail(login);
		compteSysteme.setMdp(mdp);
		compteSysteme = serviceCompteSysteme.authentificationBO(compteSysteme);

		if (compteSysteme == null) {		
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Erreur", "Compte invalide"));
			return "erreur";
		} else {
			System.out.println("Fin du MBLoginBO  : Droit d'accès  :"
					+ compteSysteme.getDroitAcces() + "   login : " + login
					+ "   mot de passe :" + mdp);
			// return "/indexBO.xhtml" + "?faces-redirect=true";
			return "success";
		}
	}

	/* --------GETTERS & SETTERS ------------ */

	public String getLogin() {
		return login;
	}

	public void setLogin(String paramLogin) {
		login = paramLogin;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String paramMdp) {
		mdp = paramMdp;
	}
}
