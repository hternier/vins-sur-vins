package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Adresse;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;
import fr.afcepf.atod17.vinsurvin.utils.enums.EnumRegex;

public class ManagedBeanCreerCompte extends AbstractManagedBean {

	private String cp;
	private int ville;
	private String mail1;
	private String mail2;
	private String mdp1;
	private String mdp2;
	private List<SelectItem> listVille = new ArrayList<SelectItem>();

	private CompteClient compteClient = new CompteClient();
	{
		compteClient.setAdresseFacturation(new Adresse());
	}

	public String creerCompte() {

//		verifEmail = getContext().getBean(ServiceCompteImpl.class).testEmail(this.mail1.trim());
//		if (verifEmail == 0) {
//			if (getMail1().equals(getMail2())) {
//				compteClient.setMail(getMail1());
//				compteClient.setDroitAcces("Client");
//				Ville v = new Ville();
//				v.setId(ville);
//				compteClient.getAdresseFacturation().setVille(v);
//				this.compteClient = getContext().getBean(ServiceCompteImpl.class).addCompteClient(compteClient);
//			} else {
//				FacesContext context = FacesContext.getCurrentInstance();  
//		          
//		        context.addMessage(null, new FacesMessage("Attention !","Vos emails ne sont pas identiques ! ")); 
//			}
//		}else{
//			FacesContext context = FacesContext.getCurrentInstance();  
//	          
//	        context.addMessage(null, new FacesMessage("Attention !","Cet email existe déja ")); 
//		}
		if (champsValides()) {
			this.compteClient.setMail(this.mail1.trim());
			this.compteClient.setDroitAcces("Client");
			this.compteClient.setMdp(this.mdp1.trim());
			this.compteClient = getContext().getBean(ServiceCompteImpl.class).addCompteClient(compteClient);
		}
		
		return "";
	}
	
	private boolean champsValides() {
		boolean retour = false;
		if (eMailValide() & champsRemplis() & mdpValide()) {
			retour = true;
		}
		return retour;
	}
	
	private boolean eMailValide() {
		boolean retour = true;
		if (!this.mail1.isEmpty()) {
			if (!this.mail1.trim().equals(this.mail2.trim())) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Les champs mail ne sont pas identiques");
			}
			
			if (!getContext().getBean(ServiceCompteImpl.class).testEmail(this.mail1.trim())) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Le mail 1 existe déjà dans le système");
			}
			
			if (!this.mail1.trim().matches(EnumRegex.MAIL.getPattern())) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Le mail 1 n'est pas un mail valide");
			}
		} else {
			retour = false;
			VinSurVinContext.afficherMessage("Erreur", "Le champ mail est obligatoire");
		}
		return retour;
	}

	private boolean champsRemplis() {
		boolean retour = true;
		if (this.compteClient.getNom().trim().isEmpty()) {
			retour = false;
			VinSurVinContext.afficherMessage("Erreur", "Le champ nom est obligatoire");
		}
		
		if (this.compteClient.getPrenom().trim().isEmpty()) {
			retour = false;
			VinSurVinContext.afficherMessage("Erreur", "Le champ prénom est obligatoire");
		}
		
		if (this.compteClient.getTel().trim().isEmpty()) {
			retour = false;
			VinSurVinContext.afficherMessage("Erreur", "Le champ téléphone est obligatoire");
		}
		return retour;
	}

	private boolean mdpValide() {
		boolean retour = true;
		if (this.mdp1.trim().isEmpty()) {
			retour = false;
			VinSurVinContext.afficherMessage("Erreur", "Le champ mot de passe est obligatoire");
		} else {
			if (!mdp1.trim().equals(mdp2.trim())) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Les champs mot de passe doivent être identiques");
			}
		}
		return retour;
	}
	
	public void villeParCP() {
		List<Ville> listeVille = new ArrayList<Ville>();
		this.listVille.clear();
		if (getCp().trim().matches(EnumRegex.CODE_POSTAL.getPattern())) {
			listeVille = getContext().getBean(ServiceCompteImpl.class)
					.getVilleParCP(getCp());
			for (Ville ville : listeVille) {
				this.listVille.add(new SelectItem(ville.getId(), ville.getVille()));
			}
		}

	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public int getVille() {
		return ville;
	}

	public void setVille(int ville) {
		this.ville = ville;
	}

	public String getMail1() {
		return mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	public CompteClient getCompteClient() {
		return compteClient;
	}
	
	public void setCompteClient(CompteClient compteClient) {
		this.compteClient = compteClient;
	}
	
	public List<SelectItem> getListVille() {
		return listVille;
	}

	public void setListVille(List<SelectItem> listVille) {
		this.listVille = listVille;
	}

	public String getMdp1() {
		return mdp1;
	}

	public void setMdp1(String mail1) {
		this.mdp1 = mail1;
	}

	public String getMdp2() {
		return mdp2;
	}

	public void setMdp2(String mail2) {
		this.mdp2 = mail2;
	}

}
