package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.Date;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCommande;

public class ServiceCommandeImpl implements IServiceCommande {

    /**
     * Instenciation de l'implémentation de la DAO commande.
     */
    private IDaoCommande daoCommande;
    private IDaoCompte daoCompte;
    private IDaoProduit daoProduit;

    /**
     * Constructeur par defaut.
     */
    public ServiceCommandeImpl() {
    }
    
    @Override
    public Commande ajoutCommande(Commande paramCommande) {
        
        Produit produitEnStock;
        for (ProduitEnCommande pec : paramCommande.getProduitsEnCommande()) {
            //TODO : (HT) Voir si quantité stock est actualiser en temps réel.
            produitEnStock = daoProduit.getProduit(pec.getProduit());
            
            if (pec.getQuantite() > produitEnStock.getStock()) {
                System.err.println("Erreur de quantité commandé. Produit :" + pec.getProduit().getLibelle()
                        + ", quantité désiré : " + pec.getQuantite() + ", quantité disponible : " + produitEnStock.getStock());
                return null;
            } else {
                produitEnStock.setStock(produitEnStock.getStock() - pec.getQuantite());
                daoProduit.setProduit(produitEnStock);
            }
        }
        
        paramCommande.setDateCommande(new Date());
        
        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setId(1);
        etatCommande = daoCommande.getEtatCommande(etatCommande);
        paramCommande.setEtatCommande(etatCommande);
        
        //TODO : (HT) Compte client à récupérer dynamiquement
        CompteClient compte = new CompteClient();
        compte.setId(1);
        compte = daoCompte.getCompteClient(compte);
        paramCommande.setClient(compte);
        
        paramCommande = daoCommande.addCommande(paramCommande);
        return paramCommande;
    }
    
    @Override
    public Commande validationCommande(Commande paramCommande) {
        // Il faut obligatoirement une adresse et un tarif de livraison.
        
        if (paramCommande.getAdresseCommande() != null) {
            if (paramCommande.getTarifLivraison() != null) {
                EtatCommande etatCommande = new EtatCommande();
                etatCommande.setId(2);
                etatCommande = daoCommande.getEtatCommande(etatCommande);
                paramCommande.setEtatCommande(etatCommande);
                
                paramCommande = daoCommande.setCommande(paramCommande);
            } else {
                System.err.println("Erreur validation commande : tarif de livraison inexistante");
            }
        } else {
            System.err.println("Erreur validation commande : adresse de livraison inexistante");
        }
        return paramCommande;
    }

    /**
     * Méthode de récupèration de la DAO commande.
     * @return La DAO produit
     */
    public IDaoCommande getDaoCommande() {
        return daoCommande;
    }

    /**
     * Méthode de définition de la DAO commande.
     * @param paramDaoProduit La DAO commande
     */
    public void setDaoCommande(IDaoCommande paramDaoCommande) {
        this.daoCommande = paramDaoCommande;
    }

    public IDaoCompte getDaoCompte() {
        return daoCompte;
    }

    public void setDaoCompte(IDaoCompte paramDaoCompte) {
        daoCompte = paramDaoCompte;
    }
    
    public IDaoProduit getDaoProduit() {
        return daoProduit;
    }

    public void setDaoProduit(IDaoProduit paramDaoProduit) {
        daoProduit = paramDaoProduit;
    }
    
}
