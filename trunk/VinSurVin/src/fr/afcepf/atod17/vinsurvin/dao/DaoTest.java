package fr.afcepf.atod17.vinsurvin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class DaoTest {
	
	public List<Produit> getAll() {
		List<Produit> listeRetour = new ArrayList<Produit>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VinSurVin");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		listeRetour = em.createQuery("From Produit", Produit.class).getResultList();
		
		tx.commit();
		em.close();
		emf.close();
		return listeRetour;
	}

}
