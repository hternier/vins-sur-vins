package fr.afcepf.atod18.controleDeStock.entitees;

import java.io.Serializable;

public class ProduitControleStock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer quantite;
	
	public ProduitControleStock() {
		
	}

	public ProduitControleStock(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
}
