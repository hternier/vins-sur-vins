package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCompteImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCompte;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceProduit;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;
import fr.afcepf.atod17.vinsurvin.utils.enums.EnumRegex;

public class ManagedBeanAccueil extends AbstractManagedBean {
	
	public final String RECHERCHE_VALIDE = "rechercheValide";
	private ManagedBeanRechercheProduit mbRechercheProduit;
	private String connexionMail;
	private String connexionMdp;
	private CompteClient clientConnected;
	private String rechercheTextuelle;
	private String recherchePrixMin;
	private String recherchePrixMax;
	private String rechercheMillesime;
	private String rechercheRegion;
	private List<String> images;  
	private List<SelectItem> listeRegion = new ArrayList<SelectItem>();
	
	public ManagedBeanAccueil() {
		
	}

	public ManagedBeanRechercheProduit getMbRechercheProduit() {
		return mbRechercheProduit;
	}

	public void setMbRechercheProduit(ManagedBeanRechercheProduit mbRechercheProduit) {
		this.mbRechercheProduit = mbRechercheProduit;
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
	
	public int getListeRegionTaille() {
		return listeRegion.size();
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

	public List<String> getImages() {
		return images;
	}

	public String rechercheMulticritere () {
		String retour = "";
		
		String savedPrixMin = this.recherchePrixMin;
		String savedPrixMax = this.recherchePrixMax;
		
		if (champsValides()) { 
			retour = RECHERCHE_VALIDE;
			mbRechercheProduit.remplirListes(rechercheMulticritere(this.rechercheTextuelle.trim(), this.rechercheMillesime.trim(), this.rechercheRegion.trim(), Double.parseDouble(this.recherchePrixMin.trim()), Double.parseDouble(this.recherchePrixMax.trim())));
		} else {
			retour = "erreurRecherche";
		}
		
		this.recherchePrixMin = savedPrixMin;
		this.recherchePrixMax = savedPrixMax;
		
		return retour;
	}
	
	public String rechercheVinRouges() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllProduitParCategorie(1));
		return RECHERCHE_VALIDE;
	}
	
	public String rechercheVinRoses() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllProduitParCategorie(3));
		return RECHERCHE_VALIDE;
	}
	
	public String rechercheVinBlancs() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllProduitParCategorie(2));
		return RECHERCHE_VALIDE;
	}
	
	public String rechercheChampagnes() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllProduitParCategorie(4));
		return RECHERCHE_VALIDE;
	}
	
	public String rechercheSpiritueux() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllSpiritueux(true));
		return RECHERCHE_VALIDE;
	}
	
	public String rechercheAccessoires() {
		mbRechercheProduit.remplirListes(getContext().getBean(ServiceProduitImpl.class).getAllAccessoires(true));
		return RECHERCHE_VALIDE;
	}
	
	public String connexion() {
		CompteClient compte = new CompteClient();
		compte.setMail(connexionMail);
		compte.setMdp(connexionMdp);
		clientConnected = getContext().getBean(IServiceCompte.class).authentificationFO(compte);
		
		if (clientConnected == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur", "Nous ne parvenons pas à vous identifier"));
		}
		
		return "";
	}
	
	public String deconnexion() {
		this.clientConnected = null;
		return "GoAccueil";
	}
	
	private boolean champsValides() {
		boolean retour = false;
		if (champMillesimeValide() & champPrixValides()) {
			retour = true;
		}
		return retour;
	}
	
	private boolean champMillesimeValide() {
		boolean retour = true;
		
		if (!this.rechercheMillesime.trim().isEmpty()) {
			int millesimeAsInt = 0;
			if (!this.rechercheMillesime.trim().matches(EnumRegex.ANNEE.getPattern())) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Millésime invalide.");
			} else {
				millesimeAsInt = Integer.parseInt(this.rechercheMillesime.trim());
				if (millesimeAsInt < 1500 || millesimeAsInt > 2200) {
					retour = false;
					VinSurVinContext.afficherMessage("Erreur", "Le millésime doit être compris entre 1500 et 2200");
				}
			}
		}
		
		return retour;
	}
	
	private boolean champPrixValides() {
		boolean retour = true;
		double prixMinAsDouble = 0;
		double prixMaxAsDouble = 0;
		
		if (!this.recherchePrixMin.trim().isEmpty() || !this.recherchePrixMax.trim().isEmpty()) {
			if (this.recherchePrixMin.trim().isEmpty() || this.recherchePrixMax.trim().isEmpty()) {
				retour = false;
				VinSurVinContext.afficherMessage("Erreur", "Si un champ prix est renseigné, l'autre est obligatoire");
			} else {
				try {
					prixMinAsDouble = Double.parseDouble(this.recherchePrixMin.trim());
					prixMaxAsDouble = Double.parseDouble(this.recherchePrixMax.trim());
					if (prixMaxAsDouble <= prixMinAsDouble) {
						retour = false;
						VinSurVinContext.afficherMessage("Erreur", "Le champ prix max est inférieur ou égal au champ prix min");
					}
				} catch (NumberFormatException e) {
					retour = false;
					VinSurVinContext.afficherMessage("Erreur", "Champ prix incorrect");
				}
			}
		} else {
			this.recherchePrixMin = "0";
			this.recherchePrixMax = "0";
		}
		
		if (!retour) {
			this.recherchePrixMin = "0";
			this.recherchePrixMax = "0";
		}
		
		return retour;
	}
	
	private List<Produit> rechercheMulticritere(String paramLibelle, String paramMillesime, String paramRegion, double paramPrixMin, double paramPrixMax) {
		List<Produit> listeRetour = null;
		IServiceProduit serviceProduit = getContext().getBean(ServiceProduitImpl.class);
		if (paramLibelle.isEmpty()) {
		// Si PAS LIBELLE
			if (paramMillesime.isEmpty()) {
			// Si PAS MILLESIME
				if (paramPrixMin == paramPrixMax) {
				// Si PAS PRIX
					if (paramRegion.isEmpty()) {
					// Si PAS REGION
						listeRetour = serviceProduit.getAllProduit(true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParRegion(paramRegion, true);
					}
				} else {
				// Si PRIX
					if (paramRegion.isEmpty()) {
					// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParPrix(paramPrixMin, paramPrixMax, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParRegionEtPrix(paramRegion, paramPrixMin, paramPrixMax, true);
					}
				}
			} else {
			// Si MILLESIME
				if (paramPrixMin == paramPrixMax) {
				// Si PAS PRIX
					if (paramRegion.isEmpty()) {
					// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParMillesime(paramMillesime, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParMillesimeEtRegion(paramMillesime, paramRegion, true);
					}
				} else {
				// Si PRIX
					if (paramRegion.isEmpty()) {
						// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParMillesimeEtPrix(paramMillesime, paramPrixMin, paramPrixMax, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParMillesimeEtRegionEtPrix(paramMillesime, paramRegion, paramPrixMin, paramPrixMax, true);
					}
				}
			}
		} else {
		// SI LIBELLE
			if (paramMillesime.isEmpty()) {
			// Si PAS MILLESIME
				if (paramPrixMin == paramPrixMax) {
				// Si PAS PRIX
					if (paramRegion.isEmpty()) {
					// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParNom(paramLibelle, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParRegionEtNom(paramRegion, paramLibelle, true);
					}
				} else {
				// Si PRIX
					if (paramRegion.isEmpty()) {
						// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParPrixEtNom(paramPrixMin, paramPrixMax, true, paramLibelle);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParRegionEtNomEtPrix(paramRegion, paramPrixMin, paramPrixMax, true, paramLibelle);
					}
				}
			} else {
			// Si MILLESIME
				if (paramPrixMin == paramPrixMax) {
				// Si PAS PRIX
					if (paramRegion.isEmpty()) {
					// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParMillesimeEtNom(paramMillesime, paramLibelle, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParMillesimeEtNomEtRegion(paramMillesime, paramLibelle, paramRegion, true);
					}
				} else {
				// Si PRIX
					if (paramRegion.isEmpty()) {
						// Si PAS REGION
						listeRetour = serviceProduit.getAllProduitParMillesimeEtNomEtPrix(paramMillesime, paramLibelle, paramPrixMin, paramPrixMax, true);
					} else {
					// Si REGION
						listeRetour = serviceProduit.getAllVinParMillesimeEtNomEtRegionEtPrix(paramMillesime, paramLibelle, paramRegion, paramPrixMin, paramPrixMax, true);
					}
				}
			}
		}
		
		return listeRetour;
	}
	
	public String creerCompte() {
		return "CreerCompte";
	}
	public String allerAccueil() {
		return "GoAccueil";
	}
	
	public String gestionPanier() {
        return "gestionPanier";
    }
	
	public String gestionCommandes() {
		return "gestionCommande";
	}
	
	public String gestionCompte() {
		return "gestionCompte";
	}
	
	 @PostConstruct  
	    public void init() {  
	        images = new ArrayList<String>();  
	  
	        for(int i=1;i<=3;i++) {  
	            images.add("vinsurvin" + i + ".jpg");  
	        }  
}}
