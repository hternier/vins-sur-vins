package fr.afcepf.atod17.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.afcepf.atod17.entitybeans.produit.Produit;

public class ManagedBeanTest {
	
	private List<Produit> listeProduit = new ArrayList<Produit>();
	
	public String testAction() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VinSurVin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TypedQuery<Produit> query = em.createQuery("From Produit", Produit.class);
		this.listeProduit = query.getResultList();
		
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
