package fr.afcepf.atod17.vinsurvin.services.interfaces;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.TarifLivraison;

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
    
    /**
     * Méthode d'annulation d'une commande.
     * Passage en statut "annuler"
     * @param paramCommande La commande à annuller
     * @return La commande annulée
     */
    public Commande annulerCommande(Commande paramCommande);

    public List<Commande> rechercheCommande(Commande paramCommande);
    
    public List<TarifLivraison> getTarifLivraisonCommande(Commande paramCommande);

    /**
     * Ajout Pour ListTarifLivraison
     * @param paramTarifLivraison
     * @return
     */
    public TarifLivraison getTarifLivraison(TarifLivraison paramTarifRechercher);

    public Commande getCommande(Commande paramCommande);

    

}
