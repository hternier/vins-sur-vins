package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceProduit;

public class ManagedBeanGestionProduits extends AbstractManagedBean {

	private String rechercheTextuelle;
	private String listeCategoriesSelected;
	private Integer listeSousCategoriesSelected;
	private List<SelectItem> listeCategories;
	private List<SelectItem> listeSousCategories;
	private List<Produit> listeProduits = new ArrayList<Produit>();
	
	/**
	 * Le produit à créer/modifier
	 */
	private Produit produit;
	
	

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
	 * Recherche par type de produit. Attention : une catégorie sur le site
	 * correspond à un type de produit dans l'application
	 **/
	public String rechercheType() {
		System.out.println("type de produit selectionné : "
				+ listeCategoriesSelected.toString());
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitParTypeProduit(listeCategoriesSelected);
		System.out.println("taille de la liste des produits triés par 1 type "
				+ listeProduits.size());
		return "";
	}

	/**
	 * Recherche de toutes les catégories de produits en base Attention : une
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

	public String rechercheTexteEtCat() {
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitsParCategorieEtTexte(listeSousCategoriesSelected,
						rechercheTextuelle);
		return "";

	}

	public String rechercheTexteEtType() {
		this.listeProduits = getContext().getBean(ServiceProduitImpl.class)
				.getAllProduitParTypeProduitEtNom(listeCategoriesSelected,
						rechercheTextuelle);
		return "";

	}

	public String rechercheMulticritere() {
		System.out.println("ds recherche multicritère");

		this.listeProduits = rechercheFiltre(rechercheTextuelle,
				listeCategoriesSelected, listeSousCategoriesSelected);

		System.out.println("taille liste produit recherche multicritères : "
				+ listeProduits.size());
		return "";
	}

	/**
	 * methode de recherche multicritère de produits pour la gestion des
	 * produits en Back office
	 **/
	public List<Produit> rechercheFiltre(String paramTextuel, String paramType,
			Integer paramCat) {
		System.out.println("Valeur de la recherche textuelle :"
				+ rechercheTextuelle.toString());
		System.out.println("Valeur de la recherche par type :"
				+ listeCategoriesSelected.toString());
		System.out.println("Valeur de la recherche par catégorie:"
				+ listeSousCategoriesSelected.toString());

		IServiceProduit serviceProduit = getContext().getBean(
				ServiceProduitImpl.class);
		// si la recherche textuelle est vide :
		if (paramTextuel.isEmpty()) {
			// si aucun type de produit n'est selectionné :
			if (paramType.isEmpty()) {
				// si aucune catégorie n'est selectionnée :
				if (paramCat == 0) {
					listeProduits = serviceProduit.getAllProduit(false);
					System.out.println("Aucun critère de recherche");
					// si une catégorie est selectionnée :
				} else {
					listeProduits = serviceProduit
							.getAllProduitParCategorie(listeSousCategoriesSelected);
					System.out
							.println("taille de la liste des produits si seule la catégorie est selectionnée : "
									+ listeProduits.size());
				}
				// Si un type de produit a été selectionné :
			} else {
				// si aucune catégorie n'est selectionnée :
				if (paramCat == 0) {
					listeProduits = serviceProduit
							.getAllProduitParTypeProduit(listeCategoriesSelected);
					System.out
							.println("taille de la liste des produits si seule le type de produit est selectionné : "
									+ listeProduits.size());
					// si une catégorie est selectionnée :
				} else {
					listeProduits = serviceProduit
							.getAllProduitParCategorie(listeSousCategoriesSelected);
					System.out
							.println("taille de la liste des produits si  un type et une catégorie sont selectionnés : "
									+ listeProduits.size());
				}
			}
			// si la recherche textuelle n'est pas vide
		} else {
			// si aucun type de produit n'est selectionné :
			if (paramType.isEmpty()) {
				// si aucune catégorie n'est selectionnée :
				if (paramCat == 0) {
					listeProduits = serviceProduit.getAllProduitParNom(
							this.rechercheTextuelle.trim(), false);
					System.out
							.println("taille de la liste des produits si seule la recherche textuelle est renseignée : "
									+ listeProduits.size());

					// si une catégorie de produit est selectionnée :
				} else {
					// si aucune catégorie n'est selectionnée :
//					if (paramCat == 0) {
						listeProduits = serviceProduit
								.getAllProduitsParCategorieEtTexte(paramCat,
										paramTextuel);
						System.out
								.println("taille de la liste des produits si la recherche textuelle + catégorie produit sont renseignés : "
										+ listeProduits.size());
						
				}	// Si une catégorie est selectionnée :
					} else {
						listeProduits = serviceProduit
								.getAllProduitParTypeProduitEtNom(paramType,
										paramTextuel);
						System.out
								.println("taille de la liste des produits si la recherche textuelle + type produit sont renseignés : "
										+ listeProduits.size());
					}
				}
		return listeProduits;
	}


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
	
    public String nouveauProduit() {
        String retour = "";
        try {
            Class c = java.lang.Class.forName("fr.afcepf.atod17.vinsurvin.entitybeans.produit." + listeCategoriesSelected);
            produit = (Produit) c.newInstance();
            
            retour = "ajoutModifProduit";
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return retour;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit paramProduit) {
        produit = paramProduit;
    }
	
	

}
