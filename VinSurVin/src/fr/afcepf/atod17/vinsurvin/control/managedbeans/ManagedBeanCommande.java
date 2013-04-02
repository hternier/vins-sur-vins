package fr.afcepf.atod17.vinsurvin.control.managedbeans;


import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ListeTarifsLivraison;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCommandeImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;


/**
 * ManagedBean de la commande.
 * @author Hadrien TERNIER
 *
 */
public class ManagedBeanCommande extends AbstractManagedBean {

    /**
     * Commande de la session.
     */
    private Commande commande = new Commande();
    private String adresse1 = "";
    private String adresse2 = "";
    private String ville = "";
    
    private Double totalCommandeTTC = 0.0;
    private Double totalCommandeHT = 0.0;
    
    private ProduitEnCommande pec =new ProduitEnCommande();
    
    private ListeTarifsLivraison tarifsLivraisonCommande;
    private String tarifLivraisonSelectionne;
    
    private String choixPaiement;
    
    public ManagedBeanCommande() {
        getCommande();
    }
    
    public List<ProduitEnCommande> getListeProduitEnCommande() {
        return this.commande.getProduitsEnCommande();
    }
    
    public Commande setCommande(Commande paramCommande) {
        return paramCommande;
    }
    
    public String getCommande() {
        //TODO : (HT) mettre en place la récupération dynamique de la commande
        this.commande.setId(1);
        this.commande = getContext().getBean(ServiceCommandeImpl.class).rechercheCommande(this.commande).get(0);
        
        return "";
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
        if (commande.getAdresseCommande() != null) {
            adresse1 =  this.commande.getAdresseCommande().getAdresse1();
        }
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
        tarifsLivraisonCommande = new ListeTarifsLivraison(getContext().getBean(ServiceCommandeImpl.class).getTarifLivraisonCommande(this.commande));
        System.out.println("setTarifsLivraisonCommande : nb lignes retournées : " + tarifsLivraisonCommande.getRowCount());
        return tarifsLivraisonCommande;
    }
    
    public ListeTarifsLivraison getTarifsLivraisonCommande() {
        System.out.println("getTarifsLivraisonCommande");
        
        if(commande.getProduitsEnCommande() != null) {
            tarifsLivraisonCommande =  setTarifsLivraisonCommande();
        }
        
        System.out.println("getTarifsLivraisonCommande : TEST : " + getContext().getBean(ListeTarifsLivraison.class).getRowKey(getContext().getBean(ListeTarifsLivraison.class).getRowData("1")));
        return tarifsLivraisonCommande;
    }

    public String getTarifLivraisonSelectionne() {
        System.out.println("getTarifLivraisonSelectionne");
        return this.tarifLivraisonSelectionne;
    }

    public void setTarifLivraisonSelectionne(
            String paramTarifLivraisonSelectionne) {
        System.out.println("setTarifLivraisonSelectionne");
        this.tarifLivraisonSelectionne = paramTarifLivraisonSelectionne;
    }

    public String getChoixPaiement() {
        return choixPaiement;
    }

    public void setChoixPaiement(String paramChoixPaiement) {
        choixPaiement = paramChoixPaiement;
    }
    
    
}
