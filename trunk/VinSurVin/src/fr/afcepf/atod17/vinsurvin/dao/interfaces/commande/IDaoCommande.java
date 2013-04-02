package fr.afcepf.atod17.vinsurvin.dao.interfaces.commande;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.TarifLivraison;

public interface IDaoCommande {
    
    /**
     * Méthode d'ajout d'une commande.
     * @param paramCommande Commande à ajouter
     * @return Commande ajoutée
     */
    public Commande addCommande(Commande paramCommande);
    
    /**
     * Méthode de récupération d'un état par son Id. 
     * @param etatCommande L'état commande à rechercher
     * @return L'état commande trouvé
     */
    public EtatCommande getEtatCommande(EtatCommande etatCommande);
    
    /**
     * Méthode de mise à jour d'une commande.
     * La commande doit existé précédement.
     * @param paramCommande La commande avec modification
     * @return La commande modifiée
     */
    public Commande setCommande(Commande paramCommande);

    public Commande getCommande(Commande paramCommande);

    public List<TarifLivraison> getTarifLivraisonCommande(int TotalUniteLivraison);

    /**
     * Méthode de récupération d'un tarif de livraison par son id. 
     * @param paramTarifLivraison Le tarif livraison à rechercher.
     * @return Le tarif livraison recherché
     */
    public TarifLivraison getTarifLivraison(TarifLivraison paramTarifLivraison);

    /**
     * Recherche multi-critère sur les commandes.
     * Par id, compte utilisateur ou statut
     * @param paramCommande
     * @return
     */
    public List<Commande> rechercheCommande(Commande paramCommande);
}
