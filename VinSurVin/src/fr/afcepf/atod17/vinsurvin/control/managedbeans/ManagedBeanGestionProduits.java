package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod17.vinsurvin.dao.DaoGestionProduits;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class ManagedBeanGestionProduits {
	private String listeCategoriesSelected;
	private String listeSousCategoriesSelected;
	private List<Produit> listeProduit = new ArrayList<Produit>();
//	private List<Vin> listeResultatVin = new ArrayList<Vin>();
//	private List<Spiritueux> listeResultatSpiritueux = new ArrayList<Spiritueux>();
//	private List<Accessoire> listeResultatAccessoire = new ArrayList<Accessoire>();
//	
	
	public String RechercheTout() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
		
		this.listeProduit = ctx.getBean("gestionProduitsBean", DaoGestionProduits.class).getAll();
		
		return "";
	}

	
	/**
	 * @return the listeProduit
	 */
	public List<Produit> getListeProduit() {
		return listeProduit;
	}


	/**
	 * @param paramListeProduit the listeProduit to set
	 */
	public void setListeProduit(List<Produit> paramListeProduit) {
		listeProduit = paramListeProduit;
	}


	/**
	 * @return the size of listeProduit
	 */
	public int getListeProduitLength() {
		return this.listeProduit.size();
	}

	/**
	 * @return the listeCategoriesSelected
	 */
	public String getListeCategoriesSelected() {
		return listeCategoriesSelected;
	}

	/**
	 * @param paramListeCategoriesSelected the listeCategoriesSelected to set
	 */
	public void setListeCategoriesSelected(String paramListeCategoriesSelected) {
		listeCategoriesSelected = paramListeCategoriesSelected;
	}

	/**
	 * @return the listeSousCategoriesSelected
	 */
	public String getListeSousCategoriesSelected() {
		return listeSousCategoriesSelected;
	}

	/**
	 * @param paramListeSousCategoriesSelected the listeSousCategoriesSelected to set
	 */
	public void setListeSousCategoriesSelected(
			String paramListeSousCategoriesSelected) {
		listeSousCategoriesSelected = paramListeSousCategoriesSelected;
	}
	
	

}
