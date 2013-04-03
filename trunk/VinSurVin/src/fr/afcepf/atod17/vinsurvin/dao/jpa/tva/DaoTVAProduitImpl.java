package fr.afcepf.atod17.vinsurvin.dao.jpa.tva;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.tva.IDaoTVAProduit;

public class DaoTVAProduitImpl implements IDaoTVAProduit {

	private EntityManagerFactory emf;
	private EntityTransaction tx;
	private EntityManager em;

	
	private final String REQ_GETALLTVAASSTRING = "SELECT tva.valeur FROM TVA tva";//  SELECT * FROM atod17_g2_vins.categorieproduit c;
	
	@Override
	public List<Double> getAllTauxTVA() {
		return em.createQuery(REQ_GETALLTVAASSTRING, Double.class).getResultList();
	}

	/**
	 * @return the emf
	 */
	public EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * @return the tx
	 */
	public EntityTransaction getTx() {
		return tx;
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param paramEmf the emf to set
	 */
	public void setEmf(EntityManagerFactory paramEmf) {
		emf = paramEmf;
	}

	/**
	 * @param paramTx the tx to set
	 */
	public void setTx(EntityTransaction paramTx) {
		tx = paramTx;
	}

	/**
	 * @param paramEm the em to set
	 */
	public void setEm(EntityManager paramEm) {
		em = paramEm;
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
