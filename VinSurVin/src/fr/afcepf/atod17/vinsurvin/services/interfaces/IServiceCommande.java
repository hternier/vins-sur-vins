package fr.afcepf.atod17.vinsurvin.services.interfaces;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;

public interface IServiceCommande {

    /**
     * Méthode de création d'une commande et décrémentation du stock.
     * Passage en statut "Attente validation"
     * @param paramCommande La commande à créer
     * @return La commande créée
     */
    public Commande ajoutCommande(Commande paramCommande);

    /**
     * Méthode de validation d'une commande.
     * Passage en statut "attente payement"
     * @param paramCommande La commande à valider
     * @return La commande validée
     */
    public Commande validationCommande(Commande paramCommande);
}
