package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité panier.
 * @author Hadrien TERNIER
 *
 */
@SuppressWarnings("serial")
public class Panier implements Serializable {

    /**
     * Liste des produits dans le panier.
     */
    private List<ProduitEnCommande> produits;

    /**
     * Constructeur par defaut.
     */
    public Panier() {
    }

    /**
     * Méthode d'obtention de la liste de produits.
     * @return La liste de produits en commande
     */
    public List<ProduitEnCommande> getProduits() {
        if (produits == null) {
            List<ProduitEnCommande> listProduitsEnCmd =
                    new ArrayList<ProduitEnCommande>();
            produits = listProduitsEnCmd;
        }

        return produits;
    }

    /**
     * Méthode de definition de la liste de produits.
     * @param paramProduits La liste de produits en commande
     */
    public void setProduits(List<ProduitEnCommande> paramProduits) {
        this.produits = paramProduits;
    }
}
