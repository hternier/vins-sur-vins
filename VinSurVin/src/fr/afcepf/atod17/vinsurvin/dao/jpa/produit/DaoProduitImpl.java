package fr.afcepf.atod17.vinsurvin.dao.jpa.produit;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class DaoProduitImpl implements IDaoProduit {

	private EntityManagerFactory emf;
	private EntityTransaction tx;
	private EntityManager em;
	
	public DaoProduitImpl() {
		
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Produit> getAll() {
		return em.createQuery("From Produit", Produit.class).getResultList();
	}
	
	@Override
	public List<Produit> getAllEnStock() {
		return em.createQuery("From Produit p Where p.stock > 0", Produit.class).getResultList();
	}

	@PostConstruct
	public void init() throws IOException {
		this.emf = Persistence.createEntityManagerFactory("VinSurVin");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		
	}
	
	@PreDestroy
	public void destroy() throws IOException {
		this.tx.commit();
		this.em.close();
		this.emf.close();
	}

}
