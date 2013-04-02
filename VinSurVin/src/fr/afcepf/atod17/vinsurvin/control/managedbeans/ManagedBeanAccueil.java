package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanAccueil extends AbstractManagedBean {
	
	private String connexionMail;
	private String connexionMdp;
	private CompteClient clientConnected;
	private String rechercheTextuelle;
	private String recherchePrixMin;
	private String recherchePrixMax;
	private String rechercheMillesime;
	private String rechercheRegion;
	private List<SelectItem> listeRegion = new ArrayList<SelectItem>();
	
	public ManagedBeanAccueil() {
		
	}

	public String getRechercheTextuelle() {
		return rechercheTextuelle;
	}

	public void setRechercheTextuelle(String rechercheTextuelle) {
		this.rechercheTextuelle = rechercheTextuelle;
	}

	public String getRecherchePrixMin() {
		return recherchePrixMin;
	}

	public void setRecherchePrixMin(String recherchePrixMin) {
		this.recherchePrixMin = recherchePrixMin;
	}

	public String getRecherchePrixMax() {
		return recherchePrixMax;
	}

	public void setRecherchePrixMax(String recherchePrixMax) {
		this.recherchePrixMax = recherchePrixMax;
	}

	public String getRechercheMillesime() {
		return rechercheMillesime;
	}

	public void setRechercheMillesime(String rechercheMillesime) {
		this.rechercheMillesime = rechercheMillesime;
	}

	public String getRechercheRegion() {
		return rechercheRegion;
	}

	public void setRechercheRegion(String rechercheRegion) {
		this.rechercheRegion = rechercheRegion;
	}

	public List<SelectItem> getListeRegion() {
		fillListeRegion();
		return listeRegion;
	}

	public void setListeRegion(List<SelectItem> listeRegion) {
		this.listeRegion = listeRegion;
	}
	
	private void fillListeRegion() {
		listeRegion.clear();
		for (String region : getContext().getBean(ServiceProduitImpl.class).getAllRegion(false)) {
			listeRegion.add(new SelectItem(region, region));
		}
	}
	
	public String getConnexionMail() {
		return connexionMail;
	}

	public void setConnexionMail(String connexionMail) {
		this.connexionMail = connexionMail;
	}

	public String getConnexionMdp() {
		return connexionMdp;
	}

	public void setConnexionMdp(String connexionMdp) {
		this.connexionMdp = connexionMdp;
	}

	public CompteClient getClientConnected() {
		return clientConnected;
	}

	public void setClientConnected(CompteClient clientConnected) {
		this.clientConnected = clientConnected;
	}

	public String rechercher () {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("test", "ça marche !"));
		if (this.rechercheTextuelle.equals("aze")) {
			return "aze";
		}
		return "";
	}
	
	public String connexion() {
		CompteClient compte = new CompteClient();
		compte.setMail(connexionMail);
		compte.setMdp(connexionMdp);
		clientConnected = getContext().getBean(ServiceCompteImpl.class).authentificationFO(compte);
		
		if (clientConnected == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur", "Nous ne parvenons pas à vous identifier"));
		}
		
		return "";
	}
	
	public String deconnexion() {
		this.clientConnected = null;
		return "";
	}
	
}
