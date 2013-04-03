package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.categorieProduit.IDaoCategorieProduit;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.tva.IDaoTVAProduit;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.typeProduit.IDaoTypeProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Prix;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.TVA;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceProduit;

/**
 * Implémentation du service Produit.
 * 
 * @author Hadrien TERNIER et Nicolas
 * 
 */
public class ServiceProduitImpl implements IServiceProduit {

	/**
	 * Instenciation de l'implémentation de la DAO produit.
	 */
	private IDaoProduit daoProduit;

	private IDaoTypeProduit daoTypeProduit;

	private IDaoCategorieProduit daoCategorieProduit;

	private IDaoTVAProduit daoTVA;

	/**
	 * Constructeur par defaut.
	 */
	public ServiceProduitImpl() {

	}

	@Override
	public List<Produit> getAllProduit(boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllEnStock();
		} else {
			listeRetour = daoProduit.getAll();
		}
		return listeRetour;
	}

	@Override
	public List<String> getAllRegion(boolean enStock) {
		List<String> listeRetour = new ArrayList<String>();
		if (enStock) {
			// TODO getAllRegion (mais que en stock) si besoin
		} else {
			listeRetour = daoProduit.getAllRegionAsString();
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParNom(String paramNom, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParNomEnStock(paramNom);
		} else {
			listeRetour = daoProduit.getAllParNom(paramNom);
		}
		return listeRetour;
	}

	@Override
	public Produit getProduit(Produit produit) {
		return daoProduit.getProduit(produit);
	}

	@Override
	public Produit setProduit(Produit produit) {
		return daoProduit.setProduit(produit);
	}

	@Override
	public Double getPrixActuelTTC(Produit paramProduit) {
		Double retour = getPrixActuelHT(paramProduit);
		retour *= 1d + paramProduit.getTva().getValeur();
		return retour;
	}

	@Override
	public List<Produit> getAllProduitParPrix(double prixMin, double prixMax,
			boolean enStock) {
		List<Produit> listeRetour = getAllProduit(enStock);
		this.filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	private void filterListeParPrix(List<Produit> paramListe, double prixMin,
			double prixMax) {
		Iterator<Produit> itProduit = paramListe.iterator();
		while (itProduit.hasNext()) {
			Produit p = itProduit.next();
			double prixP = this.getPrixActuelTTC(p);
			if (prixMin > prixP || prixMax < prixP) {
				itProduit.remove();
			}
		}
	}

	@Override
	public List<Produit> getAllProduitParPrixEtNom(double prixMin,
			double prixMax, boolean enStock, String paramNom) {
		List<Produit> listeRetour = null;
		listeRetour = getAllProduitParNom(paramNom, enStock);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public Double getPrixActuelHT(Produit paramProduit) {
		for (Prix prix : paramProduit.getPrix()) {
			if (prix.getDateDebut().before(new Date())
					&& prix.getDateFin() == null) {
				return prix.getValeurHT();
			} else if (prix.getDateDebut().before(new Date())
					&& prix.getDateFin().after(new Date())) {
				return prix.getValeurHT();
			}
		}
		return null;
	}

	public List<Produit> getAllVinParRegion(String paramRegion, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllVinParRegionEnStock(paramRegion);
		} else {
			listeRetour = daoProduit.getAllVinParRegion(paramRegion);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParRegionEtPrix(String paramRegion,
			double prixMin, double prixMax, boolean enStock) {
		List<Produit> listeRetour = this.getAllVinParRegion(paramRegion,
				enStock);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParRegionEtNom(String paramRegion,
			String paramNom, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllVinParNomEtRegionEnStock(paramNom,
					paramRegion);
		} else {
			listeRetour = daoProduit.getAllVinParNomEtRegion(paramNom,
					paramRegion);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParRegionEtNomEtPrix(String paramRegion,
			double prixMin, double prixMax, boolean enStock, String paramNom) {
		List<Produit> listeRetour = null;
		listeRetour = getAllVinParRegionEtNom(paramRegion, paramNom, enStock);
		this.filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParMillesime(String paramMillesime,
			boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParMillesimeEnStock(paramMillesime);
		} else {
			listeRetour = daoProduit.getAllParMillesime(paramMillesime);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParMillesimeEtPrix(String paramMillesime,
			double prixMin, double prixMax, boolean enStock) {
		List<Produit> listeRetour = getAllProduitParMillesime(paramMillesime,
				enStock);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParMillesimeEtNom(String paramMillesime,
			String paramNom, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParMillesimeEtNomEnStock(
					paramMillesime, paramNom);
		} else {
			listeRetour = daoProduit.getAllParMillesimeEtNom(paramMillesime,
					paramNom);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParMillesimeEtNomEtPrix(
			String paramMillesime, String paramNom, double prixMin,
			double prixMax, boolean enStock) {
		List<Produit> listeRetour = getAllProduitParMillesimeEtNom(
				paramMillesime, paramNom, true);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParMillesimeEtNomEtRegion(
			String paramMillesime, String paramNom, String paramRegion,
			boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParMillesimeEtNomEtRegionEnStock(
					paramMillesime, paramNom, paramRegion);
		} else {
			listeRetour = daoProduit.getAllParMillesimeEtNomEtRegion(
					paramMillesime, paramNom, paramRegion);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParMillesimeEtNomEtRegionEtPrix(
			String paramMillesime, String paramNom, String paramRegion,
			double prixMin, double prixMax, boolean enStock) {
		List<Produit> listeRetour = getAllVinParMillesimeEtNomEtRegion(
				paramMillesime, paramNom, paramRegion, true);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParMillesimeEtRegion(String paramMillesime,
			String paramRegion, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllVinParMillesimeEtRegionEnStock(
					paramMillesime, paramRegion);
		} else {
			listeRetour = daoProduit.getAllVinParMillesimeEtRegion(
					paramMillesime, paramRegion);
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVinParMillesimeEtRegionEtPrix(
			String paramMillesime, String paramRegion, double prixMin,
			double prixMax, boolean enStock) {
		List<Produit> listeRetour = getAllVinParMillesimeEtRegion(
				paramMillesime, paramRegion, enStock);
		filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	@Override
	public List<Produit> getAllVins(boolean enStock) {
		return daoProduit.getAllProduitByTypeProduit("Vin", enStock);
	}

	/** methode de récupération de tous les Produits de type spiritueux **/
	@Override
	public List<Produit> getAllSpiritueux(boolean enStock) {
		return daoProduit.getAllProduitByTypeProduit("Spiritueux", enStock);
	}

	/** methode de récupération de tous les Produits de type accessoires **/
	@Override
	public List<Produit> getAllAccessoires(boolean enStock) {
		return daoProduit.getAllProduitByTypeProduit("Accessoire", enStock);
	}

	/** methode de récupération d'une liste de tous les type de produit **/
	@Override
	public List<String> getAllTypeProduit() {
		return daoTypeProduit.getAllCategoriesPrimairesAsString();
	}

	/** methode de récupération d'une liste de toutes les catégories de produit **/
	@Override
	public List<Categorie> getAllCategorieProduit() {
		return daoCategorieProduit.getAllCategoriesAsString();
	}

	/**
	 * methode d'affichage d'une liste du taux de TVA pour l'ajout de produits
	 * en Back office
	 **/
	@Override
	public List<TVA> getAllTVA() {
		return daoTVA.getAllTauxTVA();
	}

	/**
	 * methode de recherche de produits par type de produit pour la gestion des
	 * produits en Back office
	 **/
	@Override
	public List<Produit> getAllProduitParTypeProduit(String paramType) {
		if (paramType.equals(Vin.class.getSimpleName())) {
			System.out
					.println("entrée dans la methode getAllProduitParTypeProduit, dans la partie VIN ");
			return getAllVins(false);
		} else if (paramType.equals(Spiritueux.class.getSimpleName())) {
			System.out
					.println("entrée dans la methode getAllProduitParTypeProduit, dans la partie SPIRITUEUX");
			return daoProduit.getAllProduitByTypeProduit("Spiritueux", false);
		} else if (paramType.equals(Accessoire.class.getSimpleName())) {
			System.out
					.println("entrée dans la methode getAllProduitParTypeProduit, dans la partie ACCESSOIRE ");
			return daoProduit.getAllProduitByTypeProduit("Accessoire", false);
		} else
			System.out
					.println("entrée dans la methode getAllProduitParTypeProduit, pas de concordance trouvée ");
		return getAllProduit(false);
	}
	
	/**
	 * methode de recherche de produits par type de produit et par texte pour la gestion des
	 * produits en Back office
	 **/
	@Override
	public List<Produit> getAllProduitParTypeProduitEtNom(String paramType, String paramText) {
		return daoProduit.getAllProduitByTypeProduitEtTexte(paramType,paramText);
	}

	/**
	 * methode de recherche de produits par catégorie pour la gestion des
	 * produits en Back office
	 **/
	@Override
	public List<Produit> getAllProduitParCategorie(Integer paramCat) {
		return daoCategorieProduit.getAllProduitsParCategorie(paramCat);
	}

	/**
	 * methode de recherche de produits par catégorie et saisie texte pour la gestion des
	 * produits en Back office
	 **/
	@Override
	public List<Produit> getAllProduitsParCategorieEtTexte(Integer paramCat, String paramText) {
		return daoCategorieProduit.getAllProduitsParCategorieEtTexte(paramCat, paramText);
	}
	
	@Override
	public Categorie getCategorie (Categorie paramCategorie) {
        return daoCategorieProduit.getCategorieParId(paramCategorie);
	    
	}
	
	@Override
	public Produit ajoutProduit (Produit paramProduit) {
	    return daoProduit.ajoutProduit(paramProduit);
	}

	/* ################## GETTERS & SETTERS ##################### */

	/**
	 * Méthode de récupèration de la DAO produit.
	 * 
	 * @return La DAO produit
	 */
	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	/**
	 * Méthode de définition de la DAO produit.
	 * 
	 * @param paramDaoProduit
	 *            La DAO produit
	 */
	public void setDaoProduit(IDaoProduit paramDaoProduit) {
		this.daoProduit = paramDaoProduit;
	}

	/**
	 * @return the daoTVA
	 */
	public IDaoTVAProduit getDaoTVA() {
		return daoTVA;
	}

	/**
	 * @param paramDaoTVA
	 *            the daoTVA to set
	 */
	public void setDaoTVA(IDaoTVAProduit paramDaoTVA) {
		daoTVA = paramDaoTVA;
	}

	/**
	 * @return the daoCategorieProduit
	 */
	public IDaoCategorieProduit getDaoCategorieProduit() {
		return daoCategorieProduit;
	}

	/**
	 * @param paramDaoCategorieProduit
	 *            the daoCategorieProduit to set
	 */
	public void setDaoCategorieProduit(
			IDaoCategorieProduit paramDaoCategorieProduit) {
		daoCategorieProduit = paramDaoCategorieProduit;
	}

	/**
	 * @return the daoTypeProduit
	 */
	public IDaoTypeProduit getDaoTypeProduit() {
		return daoTypeProduit;
	}

	/**
	 * @param paramDaoTypeProduit
	 *            the daoTypeProduit to set
	 */
	public void setDaoTypeProduit(IDaoTypeProduit paramDaoTypeProduit) {
		daoTypeProduit = paramDaoTypeProduit;
	}

}
