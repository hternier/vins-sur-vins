package fr.afcepf.atod17.vinsurvin.control.managedbeans;


import javax.faces.event.ActionEvent;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Panier;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCommandeImpl;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;


/**
 * ManagedBean du panier.
 * N'est pas stocker dans la BDD.
 * @author Hadrien TERNIER
 *
 */
public class ManagedBeanPanier extends AbstractManagedBean {

    /**
     * Panier de la session.
     */
    private Panier panier = new Panier();
    /**
     * Prix total du panier.
     */
    private Double totalPanier = 0.0;

    /**
     * Méthode d'ajout des produits au panier.
     * Ajoute un nouveau produit ou
     * une nouvelle quantité.
     * @param ev Attibut JSP
     *      (Produit) produit : produit à ajouter
     *      (int) quantite : quantité à ajouter
     */
    public void ajoutPanier(ActionEvent ev) {
        Produit produit = (Produit) ev.getComponent()
                .getAttributes().get("produit");
        int quantite = Integer.parseInt(ev.getComponent()
                .getAttributes().get("quantite").toString());
        System.out.println("Ajout produit : " + produit.toString()
                + ", quantite : " + quantite);

        for (ProduitEnCommande pec : panier.getProduits()) {
            if (pec.getProduit().getId() == produit.getId()) {
                System.out.println("objet en double");

                pec.setQuantite(pec.getQuantite() + quantite);
                System.out.println("nouvelle quantité : " + pec.getQuantite());

                updateTotalPanier();
                return;
            }
        }

        ProduitEnCommande produitCmd = new ProduitEnCommande();
        produitCmd.setProduit(produit);
        produitCmd.setQuantite(quantite);

        panier.getProduits().add(produitCmd);
        updateTotalPanier();
    }

    /**
     * Méthode de retait des produits au panier.
     * Retire un produit ou modifie sa quantité.
     * @param ev Attibut JSP
     *      (Produit) produit : produit à supprimer
     *      (int) quantite : quantité supprimer
     */
    public void retirerPanier(ActionEvent ev) {
        Produit produit = (Produit) ev.getComponent()
                .getAttributes().get("produit");
        int quantite = Integer.parseInt(ev.getComponent()
                .getAttributes().get("quantite").toString());
        System.out.println("Suppression produit : " + produit.toString()
                + ", quantite : " + quantite);

        for (ProduitEnCommande pec : panier.getProduits()) {
            if (pec.getProduit().getId() == produit.getId()) {
                if ((quantite == 0) || (pec.getQuantite() <= quantite)) {
                    System.out.println("Suppression du produit");
                    panier.getProduits().remove(pec);
                } else {
                    pec.setQuantite(pec.getQuantite() - quantite);
                    System.out.println("nouvelle quantité : "
                    + pec.getQuantite());
                }
                updateTotalPanier();
                return;
            }
        }
    }

    /**
     * Méthode de récupèration du prix total du panier.
     * @return le prix total
     */
    public Double getTotalPanier() {
        return totalPanier;
    }
    
    /**
     * Methode de validation du panier.
     * Permet de créer une commande et de valider
     * le stock disponible.
     * @return La page de redirection
     */
    public String validerPanier() {
        
        Commande commande = new Commande();
        commande.setProduitsEnCommande(panier.getProduits());
        commande = getContext().getBean(ServiceCommandeImpl.class).ajoutCommande(commande);
        
        return "";
    }

    /**
     * Méthode de mise à jour du prix total du panier.
     * @return le prix total à jour
     */
    public Double updateTotalPanier() {
        totalPanier = 0.0;
        for (ProduitEnCommande pec : panier.getProduits()) {
            totalPanier += (getContext().getBean(ServiceProduitImpl.class)
                    .getPrixActuelTTC(pec.getProduit()) * pec.getQuantite());
        }
        return totalPanier;
    }
}
