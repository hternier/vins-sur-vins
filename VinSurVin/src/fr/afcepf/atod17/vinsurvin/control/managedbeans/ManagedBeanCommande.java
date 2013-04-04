package fr.afcepf.atod17.vinsurvin.control.managedbeans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;


import fr.afcepf.atod17.vinsurvin.control.entities.VueCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ListeTarifsLivraison;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.TarifLivraison;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCommandeImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;


/**
 * ManagedBean de la commande.
 * @author Hadrien TERNIER
 *
 */
public class ManagedBeanCommande extends AbstractManagedBean {

    private ManagedBeanAccueil mbAccueil;
    private ManagedBeanPanier mbPanier;
    
    /**
     * Commande de la session.
     */
    private Commande commande = new Commande();
    private String adresse1 = "";
    private String adresse2 = "";
    private String ville = "";
    
    private Double totalCommandeTTC = 0.0;
    private Double totalCommandeHT = 0.0;
    
    
    private ListeTarifsLivraison tarifsLivraisonCommande;
    private TarifLivraison tarifLivraisonSelectionne;
    
    private String choixPaiement;
    
    private List<VueCommande> commandesEnCours;
    private List<VueCommande> commandesHistoriques;
    
    
    public ManagedBeanCommande() {
    }
    
    
    public Commande setCommande(Commande paramCommande) {
        this.commande = paramCommande;
        return this.commande;
    }
    
    public Commande getCommande() {
        
        if(this.commande.getId() == 0 && mbPanier.getCommande() == null) {
            setCommande(mbPanier.getCommande());
            System.out.println("Init commande : " + commande.getDateCommande() + ", " + commande.getEtatCommande().getLibelle());
        }
        return this.commande;
    }
    
    /**
     * Méthode de calcule du prix total TTC de la commande.
     * @return Le prix total TTC
     */
    public Double getTotalCommandeTTC() {
        totalCommandeTTC = 0.0;
        if (commande.getProduitsEnCommande() != null) {
            for (ProduitEnCommande pec : commande.getProduitsEnCommande()) {
                totalCommandeTTC += (getContext().getBean(ServiceProduitImpl.class)
                        .getPrixActuelTTC(pec.getProduit()) * pec.getQuantite());
            }
        }
        return totalCommandeTTC;
    }
    
    /**
     * Méthode de calcule du prix total HT de la commande.
     * @return Le prix total HT
     */
    public Double getTotalCommandeHT() {
        totalCommandeHT = 0.0;
        if (commande.getProduitsEnCommande() != null) {
            for (ProduitEnCommande pec : commande.getProduitsEnCommande()) {
                totalCommandeHT += (getContext().getBean(ServiceProduitImpl.class)
                        .getPrixActuelHT(pec.getProduit()) * pec.getQuantite());
            }
        }
        return totalCommandeHT;
    }
    
    public String getAdresse1() {
        System.out.println("GETAdresse1");
        if (commande.getAdresseCommande() != null) {
            adresse1 =  this.commande.getAdresseCommande().getAdresse1();
            System.out.println("GETAdresse1 : Adresse depuis commande : " + adresse1);
        }
        System.out.println("GETAdresse1 : resultat : " + adresse1);
        return adresse1;
    }
    
    public String getAdresse2() {
        if (commande.getAdresseCommande() != null) {
            adresse2 =  this.commande.getAdresseCommande().getAdresse2();
        }
        return adresse2;
    }
    
    public String getVille() {
        if (commande.getAdresseCommande() != null) {
            ville = this.commande.getAdresseCommande().getVille().getVille();
        }
        return ville;
    }
    
    public ListeTarifsLivraison setTarifsLivraisonCommande() {
        System.out.println("setTarifsLivraisonCommande");
        tarifsLivraisonCommande = 
                new ListeTarifsLivraison(getContext().getBean(ServiceCommandeImpl.class).getTarifLivraisonCommande(this.commande));
        System.out.println("setTarifsLivraisonCommande : nb lignes retournées : " + tarifsLivraisonCommande.getRowCount());
        return tarifsLivraisonCommande;
    }
    
    public ListeTarifsLivraison getTarifsLivraisonCommande() {
        if(commande.getProduitsEnCommande() != null) {
            tarifsLivraisonCommande =  setTarifsLivraisonCommande();
        }
        return tarifsLivraisonCommande;
    }

    public TarifLivraison getTarifLivraisonSelectionne() {
        return this.tarifLivraisonSelectionne;
    }

    public void setTarifLivraisonSelectionne(
            TarifLivraison paramTarifLivraisonSelectionne) {
        this.tarifLivraisonSelectionne = paramTarifLivraisonSelectionne;
    }

    public String getChoixPaiement() {
        return choixPaiement;
    }

    public void setChoixPaiement(String paramChoixPaiement) {
        choixPaiement = paramChoixPaiement;
    }
    
    /**
     * Convertion de liste commande en liste VueCommande.
     * @param paramListCommande La liste de commande
     * @return La liste VueCommande convertie
     */
    public List<VueCommande> CommandeToVueCommande(List<Commande> paramListCommande) {
        List<VueCommande> listVueCommande = new ArrayList<VueCommande>();
        for (Commande commande : paramListCommande) {
            listVueCommande.add(new VueCommande(commande));
        }
        return listVueCommande;
    }

    /**
     * Affiche des commandes ayant le statut
     * "En attente de validation" et "En attente de paiement"
     */
    public List<VueCommande> getCommandesEnCours() {
        //if(commandesEnCours == null) {
            setCommandesEnCours();
        //}
        return commandesEnCours;
    }

    /**
     * Recherches des commandes ayant le statut
     * "En attente de validation" et "En attente de paiement"
     */
    public void setCommandesEnCours() {
        Commande rechercheCommande = new Commande();
        
        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setId(1);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesEnCours = CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande));
        
        etatCommande.setId(2);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesEnCours.addAll(CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande)));
    }

    /**
     * Affiche des commandes ayant le statut
     * 'En préparation', 'En livraison', 'Traité' ou 'Annulé'
     */
    public List<VueCommande> getCommandesHistoriques() {
        
        //if(commandesHistoriques == null) {
            setCommandesHistoriques();
        //}
        return commandesHistoriques;
    }

    /**
     * Recherches des commandes ayant le statut
     * 'En préparation', 'En livraison', 'Traité' ou 'Annulé'
     */
    public void setCommandesHistoriques() {
        Commande rechercheCommande = new Commande();
        
        EtatCommande etatCommande = new EtatCommande();
        etatCommande.setId(3);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesHistoriques = CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande));
        
        etatCommande.setId(4);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesHistoriques.addAll(CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande)));
        
        etatCommande.setId(5);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesHistoriques.addAll(CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande)));
    
        etatCommande.setId(6);
        rechercheCommande.setEtatCommande(etatCommande);
        commandesHistoriques.addAll(CommandeToVueCommande(getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(rechercheCommande)));
    }
    
    public void getDetail(ActionEvent ae) {
        this.commande = (Commande) ae.getComponent().getAttributes().get("paramCommande");
    }
    
    /**
     * Methode d'annulation de la commande.
     * Les produits sont remis en stock.
     * @return rien
     */
    public String annulerCommande() {
        commande = getContext().getBean(ServiceCommandeImpl.class).annulerCommande(commande);
        setCommandesEnCours();
        setCommandesHistoriques();
        return "";
    }
    
    /**
     * Methode de reprise de validation d'une commande.
     * @return retour
     */
    public String repriseCommande() {
        return "ajoutCommande";
    }
    
    /**
     * Methode de validation de la commande.
     * La commande passe en statut "Attente de paiement"
     * @return Vers l'accueil
     */
    public String validerCommande() {
        System.out.println("tarifLivraisonSelectionne : " + tarifLivraisonSelectionne.getId());
        commande.setTarifLivraison(tarifLivraisonSelectionne);
        commande = getContext().getBean(ServiceCommandeImpl.class).validationCommande(commande);
        return "Accueil";
    }

    public ManagedBeanAccueil getMbAccueil() {
        return mbAccueil;
    }

    public void setMbAccueil(ManagedBeanAccueil paramMbAccueil) {
        mbAccueil = paramMbAccueil;
    }

    public ManagedBeanPanier getMbPanier() {
        return mbPanier;
    }

    public void setMbPanier(ManagedBeanPanier mbPanier) {
        this.mbPanier = mbPanier;
    }
    
    
}
