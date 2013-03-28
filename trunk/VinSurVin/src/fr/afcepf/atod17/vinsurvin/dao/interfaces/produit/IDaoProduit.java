package fr.afcepf.atod17.vinsurvin.dao.interfaces.produit;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public interface IDaoProduit {

	public List<Produit> getAll();
	public List<Produit> getAllEnStock();
	public Produit getProduit(Produit produit);
	public List<String> getAllRegionAsString();
	public List<Produit> getAllParNom(String paramNom);
	public List<Produit> getAllParNomEnStock(String paramNom);
	
}
