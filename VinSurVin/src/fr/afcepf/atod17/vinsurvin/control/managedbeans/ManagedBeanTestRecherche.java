package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.utils.enums.EnumRegex;

public class ManagedBeanTestRecherche extends AbstractManagedBean {
	
	private String rechercheTextuelle;
	private String recherchePrixMin;
	private String recherchePrixMax;
	private String rechercheMillesime;
	private List<SelectItem> listeRegion;
	private String listeRegionSelected;
	private List<Vin> listeResultatVin = new ArrayList<Vin>();
	private List<Spiritueux> listeResultatSpiritueux = new ArrayList<Spiritueux>();
	private List<Accessoire> listeResultatAccessoire = new ArrayList<Accessoire>();
	
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

	public List<Vin> getListeResultatVin() {
		return listeResultatVin;
	}

	public void setListeResultatVin(List<Vin> listeResultatVin) {
		this.listeResultatVin = listeResultatVin;
	}
	
	private int getListeResultatVinLength() {
		int retour = 0;
		if (listeResultatVin != null) {
			retour = listeResultatVin.size();
		}
		return retour;
	}
	
	public String getDisplayListeResultatVin() {
		return (getListeResultatVinLength() > 0)?"":"display:none;";
	}
	
	public List<Spiritueux> getListeResultatSpiritueux() {
		return listeResultatSpiritueux;
	}

	public void setListeResultatSpiritueux(List<Spiritueux> listeResultatSpiritueux) {
		this.listeResultatSpiritueux = listeResultatSpiritueux;
	}
	
	private int getListeResultatSpiritueuxLength() {
		int retour = 0;
		if (listeResultatSpiritueux != null) {
			retour = listeResultatSpiritueux.size();
		}
		return retour;
	}
	
	public String getDisplayListeResultatSpiritueux() {
		return (getListeResultatSpiritueuxLength() > 0)?"":"display:none;";
	}

	public List<Accessoire> getListeResultatAccessoire() {
		return listeResultatAccessoire;
	}

	public void setListeResultatAccessoire(List<Accessoire> listeResultatAccessoire) {
		this.listeResultatAccessoire = listeResultatAccessoire;
	}
	
	private int getListeResultatAccessoireLength() {
		int retour = 0;
		if (listeResultatAccessoire != null) {
			retour = listeResultatAccessoire.size();
		}
		return retour;
	}
	
	public String getDisplayListeResultatAccessoire() {
		return (getListeResultatAccessoireLength() > 0)?"":"display:none;";
	}

	public String rechercher() {
		if (saisieValide()) {
			ServiceProduitImpl serviceProduit = getContext().getBean(ServiceProduitImpl.class);
			if (this.rechercheTextuelle.trim().isEmpty()) {
				// SI PAS RECHERCHE PAR NOM
				if (!recherchePrixMin.trim().isEmpty()) {
					// SI RECHERCHE PAR PRIX
					if (!this.listeRegionSelected.isEmpty()) {
						//SI RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllVinParRegionEtPrix(listeRegionSelected, Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllVinParMillesimeEtRegionEtPrix(this.rechercheMillesime.trim(), this.listeRegionSelected, Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true));
						}
					} else {
						//SI PAS RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllProduitParPrix(Double.parseDouble(recherchePrixMin.trim()), Double.parseDouble(recherchePrixMax.trim()), true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllProduitParMillesimeEtPrix(this.rechercheMillesime.trim(), Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true));
						}
					}
				} else {
					// SI PAS RECHERCHE PAR PRIX
					if (!this.listeRegionSelected.isEmpty()) {
						//SI RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllVinParRegion(listeRegionSelected, true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllVinParMillesimeEtRegion(this.rechercheMillesime.trim(), this.listeRegionSelected, true));
						}
					} else {
						//SI PAS RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllProduit(true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllProduitParMillesime(this.rechercheMillesime.trim(), true));
						}
					}
				}
			} else {
				// SI RECHERCHE PAR NOM
				if (!recherchePrixMin.trim().isEmpty()) {
					// SI RECHERCHE PAR PRIX
					if (!this.listeRegionSelected.isEmpty()) {
						//SI RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllVinParRegionEtNomEtPrix(this.listeRegionSelected, Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true, this.rechercheTextuelle.trim()));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllVinParMillesimeEtNomEtRegionEtPrix(this.rechercheMillesime.trim(), this.rechercheTextuelle.trim(), this.listeRegionSelected, Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true));
						}
					} else {
						//SI PAS RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllProduitParPrixEtNom(Double.parseDouble(recherchePrixMin.trim()), Double.parseDouble(recherchePrixMax.trim()), true,	this.rechercheTextuelle.trim()));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllProduitParMillesimeEtNomEtPrix(this.rechercheMillesime.trim(), this.rechercheTextuelle.trim(), Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim()), true));
						}
					}
				} else {
					// SI PAS RECHERCHE PAR PRIX
					if (!this.listeRegionSelected.isEmpty()) {
						//SI RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllVinParRegionEtNom(this.listeRegionSelected, this.rechercheTextuelle.trim(), true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllVinParMillesimeEtNomEtRegion(this.rechercheMillesime.trim(), this.rechercheTextuelle.trim(), this.listeRegionSelected, true));
						}
					} else {
						//SI PAS RECHERCHE PAR REGION
						if (this.rechercheMillesime.trim().isEmpty()) {
							// SI PAS MILLESIME
							remplirListes(serviceProduit.getAllProduitParNom(this.rechercheTextuelle.trim(), true));
						} else {
							// SI MILLESIME
							remplirListes(serviceProduit.getAllProduitParMillesimeEtNom(this.rechercheMillesime.trim(), this.rechercheTextuelle.trim(), true));
						}
					}
				}
			}
		} else {
			System.err.println("Saisie invalide");
		}
		return "";
	}
	
	private void remplirListes (List<Produit> paramListe) {
		this.listeResultatVin.clear();
		this.listeResultatSpiritueux.clear();
		this.listeResultatAccessoire.clear();
		for (Produit produit : paramListe) {
			String produitClass = produit.getClass().getName();
			if (produitClass.equals(Vin.class.getName())) {
				this.listeResultatVin.add((Vin) produit);
			} else if (produitClass.equals(Spiritueux.class.getName())) {
				this.listeResultatSpiritueux.add((Spiritueux) produit);
			} else if (produitClass.equals(Accessoire.class.getName())) {
				this.listeResultatAccessoire.add((Accessoire) produit);
			}
		}
	}
	
	private boolean saisieValide() {
		boolean retour = true;
		if (!this.champPrixValide()) {
			retour = false;
		}
		if (retour && !this.champMillesimeValide()) {
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
	
	private boolean champMillesimeValide() {
		boolean retour = true;
		if (this.rechercheMillesime.trim().isEmpty()) {
			
		} else if (this.rechercheMillesime.trim().matches(EnumRegex.ANNEE.getPattern())) {
			int millesime = Integer.parseInt(rechercheMillesime.trim());
			if (millesime < 1700 || millesime > 2200) {
				retour = false;
			}
		} else {
			retour = false;
		}
		return retour;
	}
	
}
