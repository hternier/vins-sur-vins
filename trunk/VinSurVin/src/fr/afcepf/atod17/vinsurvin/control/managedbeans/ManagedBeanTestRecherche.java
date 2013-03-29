package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.enums.EnumRegex;

public class ManagedBeanTestRecherche extends AbstractManagedBean {
	
	private String rechercheTextuelle;
	private String recherchePrixMin;
	private String recherchePrixMax;
	private int rechercheMillesime;
	private List<SelectItem> listeRegion;
	private String listeRegionSelected;
	private List<Produit> listeResultat;
	
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
	
	public int getRechercheMillesime() {
		return rechercheMillesime;
	}
	
	public void setRechercheMillesime(int rechercheMillesime) {
		this.rechercheMillesime = rechercheMillesime;
	}
	
	public List<SelectItem> getListeRegion() {
		fillListeRegion();
		return listeRegion;
	}
	
	public void setListeRegion(List<SelectItem> listeRegion) {
		this.listeRegion = listeRegion;
	}
	
	private void fillListeRegion() {
		List<SelectItem> liste = new ArrayList<SelectItem>();
		for (String region : getContext().getBean(ServiceProduitImpl.class).getAllRegion(false)) {
			liste.add(new SelectItem(region, region));
		}
		this.listeRegion = liste;
	}

	public String getListeRegionSelected() {
		return listeRegionSelected;
	}

	public void setListeRegionSelected(String listeRegionSelected) {
		this.listeRegionSelected = listeRegionSelected;
	}

	public List<Produit> getListeResultat() {
		return listeResultat;
	}

	public void setListeResultat(List<Produit> listeResultat) {
		this.listeResultat = listeResultat;
	}
	
	public int getListeResultatLength() {
		int retour = 0;
		if (listeResultat !=null) {
			retour = listeResultat.size();
		}
		return retour;
	}
	
	public String rechercher() {
		if (saisieValide()) {
			ServiceProduitImpl serviceProduit = getContext().getBean(ServiceProduitImpl.class);
			if (this.rechercheTextuelle.trim().isEmpty()) {
				if (!recherchePrixMin.trim().isEmpty()) {
					this.listeResultat = serviceProduit.getAllProduitParPrix(Double.parseDouble(recherchePrixMin), Double.parseDouble(recherchePrixMax), true);
				} else {
					this.listeResultat = serviceProduit.getAllProduit(true);
				}
			} else {
				if (!recherchePrixMin.trim().isEmpty()) {
					this.listeResultat = serviceProduit.getAllProduitParPrixEtNom(Double.parseDouble(recherchePrixMin.trim()), Double.parseDouble(recherchePrixMax.trim()), true,	this.rechercheTextuelle.trim());
				} else {
					this.listeResultat = serviceProduit.getAllProduitParNom(this.rechercheTextuelle.trim(), true);
				}
			}
		} else {
			System.err.println("Saisie invalide");
		}
		return "";
	}
	
	private boolean saisieValide() {
		boolean retour = true;
		if (!this.champPrixValide()) {
			retour = false;
		}
		return retour;
	}
	
	private boolean champPrixValide() {
		boolean retour = true;
		if (recherchePrixMin.trim().isEmpty() && !recherchePrixMax.trim().isEmpty()) {
			retour = false;
		} else if (!recherchePrixMin.trim().isEmpty() && recherchePrixMax.trim().isEmpty()) {
			retour = false;
		} else if (!recherchePrixMin.trim().isEmpty() && !recherchePrixMax.trim().isEmpty()) {
			if (this.recherchePrixMin.matches(EnumRegex.PRIX.getPattern()) && this.recherchePrixMax.matches(EnumRegex.PRIX.getPattern())) {
				this.recherchePrixMin = this.recherchePrixMin.replace(',', '.');
				this.recherchePrixMax = this.recherchePrixMax.replace(',', '.');
				if (Double.parseDouble(recherchePrixMin) > Double.parseDouble(recherchePrixMax)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return retour;
	}
	
}
