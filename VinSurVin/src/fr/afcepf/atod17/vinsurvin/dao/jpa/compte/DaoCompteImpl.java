package fr.afcepf.atod17.vinsurvin.dao.jpa.compte;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;

public class DaoCompteImpl implements IDaoCompte{

	private EntityManagerFactory emf;
	private EntityTransaction tx;
	private EntityManager em;
	
	public DaoCompteImpl() {
		
	}
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public CompteClient setCompte(CompteClient compte){
		em.persist(compte.getAdresseFacturation());
		em.persist(compte);
		return compte;
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