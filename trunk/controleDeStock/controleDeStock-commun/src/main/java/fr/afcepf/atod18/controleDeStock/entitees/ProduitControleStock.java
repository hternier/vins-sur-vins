package fr.afcepf.atod18.controleDeStock.entitees;

import java.io.Serializable;

public class ProduitControleStock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private ProduitControleStock(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
