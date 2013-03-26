package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class ManagedBeanTest {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	
	public String testAction() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VinSurVin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		this.listeProduit = em.createQuery("From Produit", Produit.class).getResultList();
		
		tx.commit();
		em.close();
		emf.close();
		return "";
	}

	public List<Produit> getListeProduit() {
		return this.listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
	public int getListeProduitLength() {
		return this.listeProduit.size();
	}

}
