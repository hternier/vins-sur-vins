package fr.afcepf.atod17.vinsurvin.dao.jpa.commande;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommandePK;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.TarifLivraison;

public class DaoCommandeImpl implements IDaoCommande {

    private EntityManagerFactory emf;
    private EntityTransaction tx;
    private EntityManager em;
    
    public DaoCommandeImpl() {
    }
    
    
    @Override
    public Commande addCommande(Commande paramCommande) {
        this.tx.begin();
        System.out.println("Création d'une nouvelle commande : " + paramCommande.getEtatCommande().getLibelle());

        em.persist(paramCommande);
        for (ProduitEnCommande pec : paramCommande.getProduitsEnCommande()) {
            ProduitEnCommandePK id = new ProduitEnCommandePK();
            id.setIdCommande(paramCommande.getId());
            id.setIdProduit(pec.getProduit().getId());
            pec.setId(id);
            em.persist(pec);
        }
        em.flush();
        this.tx.commit();
        return paramCommande;
    }


    private final String REQ_GETETATCOMMANDE = "Select ec From EtatCommande ec where ec.id = :id";
    @Override
    public EtatCommande getEtatCommande(EtatCommande paramEtatCommande) {
        return em.createQuery(REQ_GETETATCOMMANDE, EtatCommande.class).setParameter("id", paramEtatCommande.getId()).getSingleResult();
    }


    @Override
    public Commande setCommande(Commande paramCommande) {
        this.tx.begin();
        
        em.merge(paramCommande);

        em.flush();
        this.tx.commit();
        return paramCommande;
    }
    
    @Override
    public Commande getCommande(Commande paramCommande) {
        paramCommande = em.find(Commande.class, paramCommande.getId());
        return paramCommande;
    }
    
    //TODO : (HT) rechercherCommande multi-critères (compte utilisateur, statut ou id)

    private final String REQ_GETTARIFLIVRAISONCOMMANDE = "Select tl From TarifLivraison tl where tl.uniteLivraisonMin <= :uniteRef AND tl.uniteLivraisonMax >= :uniteRef";
    
    @Override
    public List<TarifLivraison> getTarifLivraisonCommande(int TotalUniteLivraison) {
        return em.createQuery(REQ_GETTARIFLIVRAISONCOMMANDE, TarifLivraison.class).setParameter("uniteRef", TotalUniteLivraison).getResultList();
    }
    
    @Override
    public TarifLivraison getTarifLivraison(TarifLivraison paramTarifLivraison) {
        System.out.println("DAO getTarifLivraison : recherche : " + paramTarifLivraison.getId());
        paramTarifLivraison = em.find(TarifLivraison.class, paramTarifLivraison.getId());
        System.out.println("DAO getTarifLivraison : résultat : " + paramTarifLivraison.getId());
        return paramTarifLivraison;
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
