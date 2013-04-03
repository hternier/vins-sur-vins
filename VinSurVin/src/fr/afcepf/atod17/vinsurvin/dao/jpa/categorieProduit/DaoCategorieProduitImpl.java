package fr.afcepf.atod17.vinsurvin.dao.jpa.categorieProduit;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.categorieProduit.IDaoCategorieProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class DaoCategorieProduitImpl implements IDaoCategorieProduit {

	private EntityManagerFactory emf;
	private EntityTransaction tx;
	private EntityManager em;
	
	
	private final String REQ_GETALLCATEGORIESASSTRING = "SELECT c FROM Categorie c";//  SELECT * FROM atod17_g2_vins.categorieproduit c;

	@Override
	public List<Categorie> getAllCategoriesAsString() {
		return em.createQuery(REQ_GETALLCATEGORIESASSTRING, Categorie.class).getResultList();
	}
	

//	public List<Produit> getAllProduitsParCategorie(Categorie valeurCategorie) {
//		TypedQuery<Produit> query = em.createQuery(REQ_GETALLPRODUITPARCATEGORIE, Produit.class);
//		query.setParameter(1, "%" + valeurCategorie + "%");
//		return null;
//	}
	
	
	private final String REQ_GETALLPRODUITPARCATEGORIE = "FROM Produit produit WHERE produit.categorie.id = ?";
	public List<Produit> getAllProduitsParCategorie(Integer valeurCategorie) {
		TypedQuery<Produit> query = em.createQuery(REQ_GETALLPRODUITPARCATEGORIE, Produit.class);
		query.setParameter(1, valeurCategorie);
		return query.getResultList();
	}
	
//	@Override
//	public List<Produit> getAllProduitsParCategorie(String paramValeurCategorie) {
//		// TODO Auto-generated method stub
//		return null;
//	}

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