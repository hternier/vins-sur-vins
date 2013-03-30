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
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
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
	
	@Override
	public Produit setProduit(Produit paramproduit) {
	    this.tx.begin();
	    
	    em.merge(paramproduit);

        em.flush();
        this.tx.commit();
        return paramproduit;
	}

	private final String REQ_GETALL = "From Produit p";
	
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
	public List<Produit> getAllVinParRegion(String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARREGION, Produit.class).setParameter(1, paramRegion).getResultList();
	}

	private final String REQ_GETALLVINPARREGIONENSTOCK = "From Vin v Where v.region = ? And v.stock > 0";
	
	@Override
	public List<Produit> getAllVinParRegionEnStock(String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARREGIONENSTOCK, Produit.class).setParameter(1, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLVINPARNOMETREGION = "From Vin v Where v.libelle like ? And v.region = ?";

	@Override
	public List<Produit> getAllVinParNomEtRegion(String paramNom,
			String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARNOMETREGION, Produit.class).setParameter(1, "%" + paramNom + "%").setParameter(2, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLVINPARNOMETREGIONENSTOCK = "From Vin v Where v.libelle like ? And v.region = ? and v.stock > 0";

	@Override
	public List<Produit> getAllVinParNomEtRegionEnStock(String paramNom,
			String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARNOMETREGIONENSTOCK, Produit.class).setParameter(1, "%" + paramNom + "%").setParameter(2, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLPARMILLESIME = "From Produit p Where p.millesime = ?";

	@Override
	public List<Produit> getAllParMillesime(String paramMillesime) {
		return em.createQuery(REQ_GETALLPARMILLESIME, Produit.class).setParameter(1, paramMillesime).getResultList();
	}

	private final String REQ_GETALLPARMILLESIMEENSTOCKVIN = "From Vin p Where p.millesime = ? And p.stock > 0";
	private final String REQ_GETALLPARMILLESIMEENSTOCKSPI = "From Spiritueux p Where p.millesime = ? And p.stock > 0";
	
	@Override
	public List<Produit> getAllParMillesimeEnStock(String paramMillesime) {
		List<Produit> listeRetour = em.createQuery(REQ_GETALLPARMILLESIMEENSTOCKSPI, Produit.class).setParameter(1, paramMillesime).getResultList();
		listeRetour.addAll(em.createQuery(REQ_GETALLPARMILLESIMEENSTOCKVIN, Produit.class).setParameter(1, paramMillesime).getResultList());
		return listeRetour;
	}

	private final String REQ_GETALLPARMILLESIMEETNOMVIN = "From Vin v Where v.millesime = ? And v.libelle like ?";
	private final String REQ_GETALLPARMILLESIMEETNOMSPI = "From Spiritueux v Where v.millesime = ? And v.libelle like ?";

	@Override
	public List<Produit> getAllParMillesimeEtNom(String paramMillesime,
			String paramNom) {
		List<Produit> listeRetour = em.createQuery(REQ_GETALLPARMILLESIMEETNOMVIN, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").getResultList();
		listeRetour.addAll(em.createQuery(REQ_GETALLPARMILLESIMEETNOMSPI, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").getResultList());
		return listeRetour;
	}
	
	private final String REQ_GETALLPARMILLESIMEETNOMENSTOCKVIN = "From Vin v Where v.millesime = ? And v.libelle like ? And v.stock > 0";
	private final String REQ_GETALLPARMILLESIMEETNOMENSTOCKSPI = "From Spiritueux v Where v.millesime = ? And v.libelle like ? And v.stock > 0";

	@Override
	public List<Produit> getAllParMillesimeEtNomEnStock(String paramMillesime,
			String paramNom) {
		List<Produit> listeRetour = em.createQuery(REQ_GETALLPARMILLESIMEETNOMENSTOCKVIN, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").getResultList();
		listeRetour.addAll(em.createQuery(REQ_GETALLPARMILLESIMEETNOMENSTOCKSPI, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").getResultList());
		return listeRetour;
	}
	
	private final String REQ_GETALLPARMILLESIMEETNOMETREGION = "From Vin v Where v.millesime = ? And v.libelle like ? And v.region = ?";

	@Override
	public List<Produit> getAllParMillesimeEtNomEtRegion(String paramMillesime,
			String paramNom, String paramRegion) {
		return em.createQuery(REQ_GETALLPARMILLESIMEETNOMETREGION, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").setParameter(3, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLPARMILLESIMEETNOMETREGIONENSTOCK = "From Vin v Where v.millesime = ? And v.libelle like ? And v.region = ? And v.stock > 0";

	@Override
	public List<Produit> getAllParMillesimeEtNomEtRegionEnStock(
			String paramMillesime, String paramNom, String paramRegion) {
		return em.createQuery(REQ_GETALLPARMILLESIMEETNOMETREGIONENSTOCK, Produit.class).setParameter(1, paramMillesime).setParameter(2, "%" + paramNom + "%").setParameter(3, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLVINPARMILLESIMEETREGION = "From Vin v Where v.millesime = ? And v.region = ?";

	@Override
	public List<Produit> getAllVinParMillesimeEtRegion(String paramMillesime,
			String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARMILLESIMEETREGION, Produit.class).setParameter(1, paramMillesime).setParameter(2, paramRegion).getResultList();
	}

	private final String REQ_GETALLVINPARMILLESIMEETREGIONENSTOCK = "From Vin v Where v.millesime = ? And v.region = ? And v.stock > 0";

	@Override
	public List<Produit> getAllVinParMillesimeEtRegionEnStock(
			String paramMillesime, String paramRegion) {
		return em.createQuery(REQ_GETALLVINPARMILLESIMEETREGIONENSTOCK, Produit.class).setParameter(1, paramMillesime).setParameter(2, paramRegion).getResultList();
	}
	
	private final String REQ_GETALLVIN = "From Vin p";
	private final String REQ_GETALLSPIRITUEUX = "From Spiritueux p";
	private final String REQ_GETALLACCESSOIRE = "From Accessoire p";

	@Override
	public List<Produit> getAllProduitByTypeProduit(String paramType, boolean enStock) {
		String requeteFinale = "";
		if (paramType.equals(Vin.class.getSimpleName())) {
			requeteFinale += REQ_GETALLVIN;
		} else if (paramType.equals(Spiritueux.class.getSimpleName())) {
			requeteFinale += REQ_GETALLSPIRITUEUX;
		} else if (paramType.equals(Accessoire.class.getSimpleName())) {
			requeteFinale += REQ_GETALLACCESSOIRE;
		}
			
		if (enStock) {
			requeteFinale = ajouterStockARequete(requeteFinale);
		}
		
		return em.createQuery(requeteFinale, Produit.class).getResultList();
	}
	
	private final String ADD_STOCK_WHERE = "Where stock > 0";
	
	private String ajouterStockARequete(String paramString) {
		return paramString + " " + ADD_STOCK_WHERE;
	}

	@Override
	public List<Produit> getProduitParRechercheMulticritere(
			String paramLibelle, String paramMillesime, String paramRegion) {
			
		//FIXME C'est le bordel
		
		return em.createQuery("From Spiritueux, Vin Where millesime = " + paramMillesime, Produit.class).getResultList();
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
