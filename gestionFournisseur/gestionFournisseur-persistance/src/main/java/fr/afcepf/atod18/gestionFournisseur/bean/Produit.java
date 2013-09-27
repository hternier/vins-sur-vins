package fr.afcepf.atod18.gestionFournisseur.bean;

public class Produit {
	private Integer id;
	private Integer quantiteCommandee;	
	private Integer idFournisseur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantiteStock() {
		return quantiteCommandee;
	}

	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteCommandee = quantiteStock;
	}

	public Integer getQuantiteCommandee() {
		return quantiteCommandee;
	}

	public void setQuantiteCommandee(Integer quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

}
