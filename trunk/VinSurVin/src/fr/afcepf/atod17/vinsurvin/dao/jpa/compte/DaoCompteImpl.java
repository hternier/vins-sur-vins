package fr.afcepf.atod17.vinsurvin.dao.jpa.compte;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteAbstrait;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Ville;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public class DaoCompteImpl implements IDaoCompte {

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
	public CompteClient setCompte(CompteClient compte) {
		this.tx.begin();
		em.persist(compte.getAdresseFacturation());
		em.persist(compte);
		em.flush();
		this.tx.commit();
		return compte;
	}

	private final String REQ_RECHERCHEVILLEPARCP = "FROM Ville v WHERE v.cp=? ";

	@Override
	public List<Ville> getVilleParCP(String cp) {
		return em.createQuery(REQ_RECHERCHEVILLEPARCP, Ville.class).setParameter(1, cp).getResultList();
	}

	private final String REQ_ALLCLIENTS = "FROM CompteAbstrait c where c.mail = ?";
	
	@Override
	public Long testEmail(String mail) {
		return (long) em.createQuery(REQ_ALLCLIENTS, CompteAbstrait.class).setParameter(1, mail.trim()).getResultList().size();
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

	private final String REQ_AUTHENTIFICATIONGESTIONNAIRE = "FROM CompteSysteme c WHERE idetatcompte=1 and mailcompte=? and mdpcompte=?";

	@Override
	public CompteSysteme authentificationBO(String login, String mdp) {
		CompteSysteme retour = null;
		try {
			retour = (CompteSysteme) em
					.createQuery(REQ_AUTHENTIFICATIONGESTIONNAIRE,
							CompteAbstrait.class).setParameter(1, login)
					.setParameter(2, mdp).getSingleResult();
			System.out.println(" est passé dans le dao compte impl");
		} catch (NoResultException exception) {
			System.out.println("no result exception dans le dao compte impl");
		}
		return retour;
	}

	private final String REQ_AUTHENTIFICATIONFO = "From CompteClient c Where c.mail = ? And c.mdp = ? And c.etatCompte = 1";

	@Override
	public CompteClient authentificationFO(String paramMail, String paramMdp) {
		CompteClient retour;
		try {
			retour = em.createQuery(REQ_AUTHENTIFICATIONFO, CompteClient.class)
					.setParameter(1, paramMail).setParameter(2, paramMdp)
					.getSingleResult();
		} catch (NoResultException e) {
			retour = null;
		}
		return retour;
	}

}