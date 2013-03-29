package fr.afcepf.atod17.vinsurvin.dao.interfaces.commande;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;

public interface IDaoCommande {
    
    public Commande addCommande(Commande paramCommande);
    public EtatCommande getEtatCommande(EtatCommande etatCommande);
}
