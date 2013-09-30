package fr.afcepf.atod17.vinsurvin.services.interfaces;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;


public interface IServiceStock {
	
	public int getStockActuel(Produit produit);

	public boolean passerCommande(Commande commande);
	
	public void ping(String string);

}
