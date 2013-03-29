package fr.afcepf.atod17.vinsurvin.dao.jpa.produit;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;

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
	public Produit getProduit(Produit paramProduit) {
		return em.find(Produit.class, paramProduit.getId());
	}

	private final String REQ_GETALL = "From Produit";
	
	@Override
	public List<Produit> getAll() {
		return em.createQuery(REQ_GETALL, Produit.class).getResultList();
	}
	
	private final String REQ_GETALLENSTOCK = "From Produit p Where p.stock > 0";
	
	@Override
	public List<Produit> getAllEnStock() {
		return em.createQuery(REQ_GETALLENSTOCK, Produit.class).getResultList();
	}
	
	private final String REQ_GETALLREGIONASSTRING = "Select distinct v.region From Vin v order by v.region";

	@Override
	public List<String> getAllRegionAsString() {
		return em.createQuery(REQ_GETALLREGIONASSTRING, String.class).getResultList();
	}

	private final String REQ_GETALLPARNOM = "From Produit p Where p.libelle like %:paramNom%";

	@Override
	public List<Produit> getAllParNom(String paramNom) {
		TypedQuery<Produit> query = em.createQuery(REQ_GETALLPARNOM, Produit.class);
		query.setParameter("paramNom", paramNom);
		return query.getResultList();
	}

	private final String REQ_GETALLPARNOMENSTOCK = "From Produit p Where p.libelle like ? AND p.stock > 0";

	@Override
	public List<Produit> getAllParNomEnStock(String paramNom) {
		TypedQuery<Produit> query = em.createQuery(REQ_GETALLPARNOMENSTOCK, Produit.class);
		query.setParameter(1, "%" + paramNom + "%");
		return query.getResultList();
	}
	
	private final String REQ_GETALLVINPARREGION = "From Vin v Where v.region = ?";

	@Override
	public List<Vin> getAllVinParRegion(String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARREGION, Vin.class).setParameter(1, paramRegion).getResultList();
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
