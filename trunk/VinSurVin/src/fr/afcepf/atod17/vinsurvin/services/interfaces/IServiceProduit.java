package fr.afcepf.atod17.vinsurvin.services.interfaces;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public interface IServiceProduit {

	public List<Produit> getAllProduit(boolean enStock);
	public Produit getProduit(Produit produit);
	public Double getPrixActuel(Produit paramProduit);
}
