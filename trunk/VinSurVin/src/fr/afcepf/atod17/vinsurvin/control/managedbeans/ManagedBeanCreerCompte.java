package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Adresse;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;
import fr.afcepf.atod17.vinsurvin.utils.enums.EnumRegex;

public class ManagedBeanCreerCompte extends AbstractManagedBean {

	private String cp;
	private int ville;
	private String mail1;
	private String mail2;
	private List<SelectItem> listVille = new ArrayList<SelectItem>();
	private Long verifEmail;
	public List<SelectItem> getListVille() {
		return listVille;
	}

	public void setListVille(List<SelectItem> listVille) {
		this.listVille = listVille;
	}

	private CompteClient compteClient = new CompteClient();
	{
		compteClient.setAdresseFacturation(new Adresse());
	}

	public String creerCompte() {

		verifEmail = getContext().getBean(ServiceCompteImpl.class).testEmail(this.mail1.trim());
		if (verifEmail == 0){
					
		if (getMail1().equals(getMail2()))
		{
			compteClient.setMail(getMail1());
		
		compteClient.setDroitAcces("Client");
		Ville v = new Ville();
		v.setId(ville);
		compteClient.getAdresseFacturation().setVille(v);
		this.compteClient = getContext().getBean(ServiceCompteImpl.class)
				.addCompteClient(compteClient);
		}else 
		{
			FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Attention !","Vos emails ne sont pas identiques ! ")); 
		}}else{
			FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Attention !","Cet email existe déja ")); 
		}
		return "";
	}

	public CompteClient getCompteClient() {
		return compteClient;
	}

//	public void testEmail(ActionEvent actionEvent){
//		
//		if (getMail1().equals(getMail2()))
//		{
//			compteClient.setMail(getMail1());
//		}else
//		{
//			FacesContext context = FacesContext.getCurrentInstance();  
//	          
//	        context.addMessage(null, new FacesMessage("Attention !", "Vos emails ne sont pas identiques ! ")); 
//		}
//	}
	public void setCompteClient(CompteClient compteClient) {
		this.compteClient = compteClient;
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

}
