package fr.afcepf.atod17.vinsurvin.dao.interfaces.produit;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public interface IDaoProduit {

	public List<Produit> getAll();
	public List<Produit> getAllEnStock();
	public Produit getProduit(Produit produit);
	/**
	 * Méthode de mise à jour d'un produit.
	 * Le produit doit existé précédement dans la BDD.
	 * @param produit Le produit ayant les nouvelles valeurs.
	 * @return Le produit avec les nouvelles valeurs.
	 */
	public Produit setProduit(Produit produit);
	public List<String> getAllRegionAsString();
	public List<Produit> getAllParNom(String paramNom);
	public List<Produit> getAllParNomEnStock(String paramNom);
	public List<Produit> getAllVinParRegion(String paramRegion);
	public List<Produit> getAllParMillesime(String paramMillesime);
	public List<Produit> getAllVinParRegionEnStock(String paramRegion);
	public List<Produit> getAllParMillesimeEnStock(String paramMillesime);
	public List<Produit> getAllVinParNomEtRegion(String paramNom, String paramRegion);
	public List<Produit> getAllVinParNomEtRegionEnStock(String paramNom, String paramRegion);
	public List<Produit> getAllParMillesimeEtNom(String paramMillesime, String paramNom);
	public List<Produit> getAllParMillesimeEtNomEnStock(String paramMillesime, String paramNom);
	public List<Produit> getAllParMillesimeEtNomEtRegion(String paramMillesime, String paramNom, String paramRegion);
	public List<Produit> getAllParMillesimeEtNomEtRegionEnStock(String paramMillesime, String paramNom, String paramRegion);
	public List<Produit> getAllVinParMillesimeEtRegion(String paramMillesime, String paramRegion);
	public List<Produit> getAllVinParMillesimeEtRegionEnStock(String paramMillesime, String paramRegion);
	public List<Produit> getAllProduitByTypeProduit(String paramType, boolean enStock);
	public List<Produit> getProduitParRechercheMulticritere(String paramLibelle, String paramMillesime, String paramRegion);
	List<Produit> getAllProduitByTypeProduitEtTexte(String paramType,
			String paramText);

}
