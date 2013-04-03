package fr.afcepf.atod17.vinsurvin.control.entities;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;

public class VueCommande {
    private Commande commande;
    private Double prixTotalTTC;
    
    public VueCommande (Commande paramCommande) {
        commande = paramCommande;
    }
    
    public Double getPrixTotalTTC() {
        prixTotalTTC = 0.0;
        if (commande.getProduitsEnCommande() != null) {
            for (ProduitEnCommande pec : commande.getProduitsEnCommande()) {
                prixTotalTTC += pec.getProduit().getPrixActuelTTC() * pec.getQuantite();
            }
        }
        return prixTotalTTC;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande paramCommande) {
        commande = paramCommande;
    }

    
}
