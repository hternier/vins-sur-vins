package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.Date;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteClient;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCommande;

public class ServiceCommandeImpl implements IServiceCommande {

    /**
     * Instenciation de l'implémentation de la DAO commande.
     */
    private IDaoCommande daoCommande;
    private IDaoCompte daoCompte;

    /**
     * Constructeur par defaut.
     */
    public ServiceCommandeImpl() {
    }
    
    @Override
    public Commande ajoutCommande(Commande paramCommande) {
      //TO DO : Décrémentation du stock (et annulation si impossible)
        
        paramCommande.setDateCommande(new Date());
        
        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setId(1);
        etatCommande = daoCommande.getEtatCommande(etatCommande);
        paramCommande.setEtatCommande(etatCommande);
        
        //TO DO : Compte client à récupérer dynamiquement
        CompteClient compte = new CompteClient();
        compte.setId(1);
        compte = daoCompte.getCompteClient(compte);
        
        paramCommande.setClient(compte);
        paramCommande.setAdresseCommande(compte.getAdresseLivraison());
        
        paramCommande = daoCommande.addCommande(paramCommande);
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
    
}
