package fr.afcepf.atod17.vinsurvin.services.interfaces;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;

public interface IServiceProduit {

	/**
	 * <b>getAllProduit</b> Méthode pour obtenir tous les produits.<br />
	 * 
	 * @param enStock : boolean, Si vrai, ne seront retournés que les Produits en stock
	 * @return
	 */
	public List<Produit> getAllProduit(boolean enStock);
	
	/**
     * Méthode de récupèration d'un produit par son Id.
     * @param produit Le produit à récupérer.
     * @return Le produit récupéré
     */
	public Produit getProduit(Produit produit);
	
	/**
	 * <b>getAllRegion</b> Méthode pour obtenir toutes les régions de vin.
	 * 
	 * @param enStock : boolean, Si vrai, ne seront retournés que les region dont les vins sont en stock
	 * @return
	 */
	public List<String> getAllRegion(boolean enStock);
	
	/**
	 * <b>getAllProduitParNom</b> Méthode pour rechercher des produits par nom.
	 * @param paramNom : la chaîne de recherche
	 * @param enStock : boolean, si vrai, ne seront retrournés que des produits en stock.
	 * @return
	 */
	public List<Produit> getAllProduitParNom(String paramNom, boolean enStock);
	
	public List<Produit> getAllProduitParPrix (double prixMin, double prixMax, boolean enStock);
	
	public List<Produit> getAllProduitParPrixEtNom (double prixMin, double prixMax, boolean enStock, String paramNom);
	
	 /**
     * Méthode de récupèration du prix actuel TTC du produit.
     * @param paramProduit Le produit ayant un prix.
     * @return Le prix TTC actuel
     */
	public Double getPrixActuelTTC(Produit paramProduit);
	public List<Produit> getAllVinParRegion(String paramRegion, boolean enStock);
	public List<Produit> getAllVinParRegionEtPrix (String paramRegion, double prixMin, double prixMax, boolean enStock);
	public List<Produit> getAllVinParRegionEtNom (String paramRegion, String paramNom, boolean enStock);
	public List<Produit> getAllVinParRegionEtNomEtPrix(String paramRegion, double prixMin, double prixMax, boolean enStock, String paramNom);
	public List<Produit> getAllProduitParMillesime (String paramMillesime, boolean enStock);
	public List<Produit> getAllProduitParMillesimeEtPrix (String paramMillesime, double prixMin, double prixMax, boolean enStock);
	public List<Produit> getAllProduitParMillesimeEtNom (String paramMillesime, String paramNom, boolean enStock);
	public List<Produit> getAllProduitParMillesimeEtNomEtPrix (String paramMillesime, String paramNom, double prixMin, double prixMax, boolean enStock);
	public List<Produit> getAllVinParMillesimeEtNomEtRegion(String paramMillesime, String paramNom, String paramRegion, boolean enStock);
	public List<Produit> getAllVinParMillesimeEtNomEtRegionEtPrix(String paramMillesime, String paramNom, String paramRegion, double prixMin, double prixMax, boolean enStock);
	public List<Produit> getAllVinParMillesimeEtRegion(String paramMillesime, String paramRegion, boolean enStock);
	public List<Produit> getAllVinParMillesimeEtRegionEtPrix(String paramMillesime, String paramRegion, double prixMin, double prixMax, boolean enStock);
	
	
	/**
     * Méthode de récupèration du prix actuel HT du produit.
     * @param paramProduit Le produit ayant un prix.
     * @return Le prix HT actuel
     */
    public Double getPrixActuelHT(Produit paramProduit);

    /**
     * Méthode de mise à jour d'un produit.
     * Le produit doit existé précédement dans la BDD.
     * @param paramProduit Le produit ayant les nouvelles valeurs.
     * @return Le produit avec les nouvelles valeurs.
     */
    public Produit setProduit(Produit paramProduit);
    
    public List<Produit> getAllVins(boolean enStock);
    public List<Produit> getAllSpiritueux(boolean enStock);
    public List<Produit> getAllAccessoires(boolean enStock);
}
