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
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

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
	    this.tx.begin();
		em.persist(compte.getAdresseFacturation());
		em.persist(compte);
		em.flush();
		this.tx.commit();
		return compte;
	}
	
	@Override
    public CompteClient getCompteClient(CompteClient paramCompteClient) {
        return em.find(CompteClient.class, paramCompteClient.getId());
    }
	
	
	@PostConstruct
	public void init() throws IOException {
		this.emf = Persistence.createEntityManagerFactory("VinSurVin");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
		
	}
	
	@PreDestroy
	public void destroy() throws IOException {
		this.em.close();
		this.emf.close();
	}
}