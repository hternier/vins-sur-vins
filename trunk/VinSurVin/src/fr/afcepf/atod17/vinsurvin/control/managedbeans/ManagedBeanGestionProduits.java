package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanGestionProduits extends AbstractManagedBean {

	private String rechercheTextuelle;

	private String listeCategoriesSelected;
	private Integer listeSousCategoriesSelected;
	private List<SelectItem> listeCategories;
	private List<SelectItem> listeSousCategories;
	private List<Produit> listeProduits = new ArrayList<Produit>();

	/**
	 * Constructeur par défaut
	 */
	public ManagedBeanGestionProduits() {
	}

	/** Recherche Tous les produits en base **/
	public String rechercheTout() {
		this.listeProduits = getContext().getBean("serviceProduit",
				ServiceProduitImpl.class).getAllProduit(false);
		System.out.println("taille de la liste des produits"
				+ listeProduits.size());
		return "";
	}

	/** Gestion de la recherche textuelle **/
	public String rechercheTextuelle() {
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitParNom(this.rechercheTextuelle.trim(), false);
		return "";
	}

	/**
	 * Recherche par type de produit. 
	 * Attention : une catégorie sur le site correspond à un type de produit dans l'application
	 **/
	public String rechercheType() {
		System.out.println("type de produit selectionné : "+listeCategoriesSelected.toString());
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitParTypeProduit(listeCategoriesSelected);
		System.out.println("taille de la liste des produits triés par 1 type "
				+ listeProduits.size());
		return "";
	}

	/**
	 * Recherche de toutes les catégories de produits en base 
	 * Attention : une
	 * sous-catégorie sur le site correspond à une catégorie produit dans
	 * l'application
	 **/
	public String rechercheCat() {
		System.out.println(listeSousCategoriesSelected);
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitParCategorie(listeSousCategoriesSelected);
		System.out
				.println("taille de la liste des produits triés par 1 categorie "
						+ listeProduits.size());
		return "";
	}

	/** Recherche Tous les produits avec la recherche textuelle **/
	public String rechercheFiltre() {
		System.out.println(rechercheTextuelle.toString());
		System.out.println(listeCategoriesSelected.toString());
		System.out.println(listeSousCategoriesSelected.toString());
		this.listeProduits = getContext().getBean("serviceProduit",
				ServiceProduitImpl.class).getAllProduitParNom(
				rechercheTextuelle, false);
		return "";
	}

	// public String rechercheDynamique () {
	// ServiceProduitImpl serviceProduit =
	// this.getContext().getBean(ServiceProduitImpl.class);
	// remplirListes(serviceProduit.getDaoProduit().getProduitParRechercheMulticritere(rechercheTextuelle,
	// listeCategoriesSelected, listeSousCategoriesSelected));
	// return "";
	// }
	//
	// private void remplirListes (List<Produit> paramListe) {
	// this.listeProduits.clear();
	// for (Produit produit : paramListe) {
	// String produitClass = produit.getClass().getName();
	// this.listeProduits.add(produit);
	// }
	// }

	/** gestion de la liste des catégories primaires **/

	private void fillListeCategories() {
		List<SelectItem> liste = new ArrayList<SelectItem>();
		for (String typeProduit : getContext()
				.getBean(ServiceProduitImpl.class).getAllTypeProduit()) {
			liste.add(new SelectItem(typeProduit, typeProduit));
		}
		this.listeCategories = liste;
	}

	/** gestion de la liste des sous-catégories primaires **/

	private void fillListeSousCategories() {
		List<SelectItem> liste = new ArrayList<SelectItem>();

		for (Categorie categorie : getContext().getBean(
				ServiceProduitImpl.class).getAllCategorieProduit()) {
			liste.add(new SelectItem(categorie.getId(), categorie.getValeur()));
		}
		this.listeSousCategories = liste;
	}

	/* ################## GETTERS & SETTERS ##################### */

	/**
	 * @return the rechercheTextuelle
	 */
	public String getRechercheTextuelle() {
		return rechercheTextuelle;
	}

	/**
	 * @return the listeSousCategoriesSelected
	 */
	public Integer getListeSousCategoriesSelected() {
		return listeSousCategoriesSelected;
	}

	/**
	 * @param paramListeSousCategoriesSelected
	 *            the listeSousCategoriesSelected to set
	 */
	public void setListeSousCategoriesSelected(
			Integer paramListeSousCategoriesSelected) {
		listeSousCategoriesSelected = paramListeSousCategoriesSelected;
	}

	/**
	 * @return the listeProduits
	 */
	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	/**
	 * @param paramRechercheTextuelle
	 *            the rechercheTextuelle to set
	 */
	public void setRechercheTextuelle(String paramRechercheTextuelle) {
		rechercheTextuelle = paramRechercheTextuelle;
	}

	/**
	 * @param paramListeProduits
	 *            the listeProduits to set
	 */
	public void setListeProduits(List<Produit> paramListeProduits) {
		listeProduits = paramListeProduits;
	}

	/**
	 * @return the listeCategories
	 */
	public List<SelectItem> getListeCategories() {
		fillListeCategories();
		return listeCategories;
	}

	/**
	 * @return the listeSousCategories
	 */
	public List<SelectItem> getListeSousCategories() {
		fillListeSousCategories();
		return listeSousCategories;
	}

	/**
	 * @return the listeCategoriesSelected
	 */
	public String getListeCategoriesSelected() {
		return listeCategoriesSelected;
	}

	// /**
	// * @return the listeSousCategoriesSelected
	// */
	// public String getListeSousCategoriesSelected() {
	// return listeSousCategoriesSelected;
	// }
	//

	/**
	 * @param paramListeCategoriesSelected
	 *            the listeCategoriesSelected to set
	 */
	public void setListeCategoriesSelected(String paramListeCategoriesSelected) {
		listeCategoriesSelected = paramListeCategoriesSelected;
	}

	/**
	 * @param paramListeSousCategoriesSelected
	 *            the listeSousCategoriesSelected to set
	 */
	// public void setListeSousCategoriesSelected(
	// String paramListeSousCategoriesSelected) {
	// listeSousCategoriesSelected = paramListeSousCategoriesSelected;
	// }
	/**
	 * @param paramListeCategories
	 *            the listeCategories to set
	 */
	public void setListeCategories(List<SelectItem> paramListeCategories) {
		this.listeCategories = paramListeCategories;
	}

	/**
	 * @param paramListeSousCategories
	 *            the listeSousCategories to set
	 */
	public void setListeSousCategories(List<SelectItem> paramListeSousCategories) {

		this.listeSousCategories = paramListeSousCategories;
	}

}
