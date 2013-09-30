package fr.afcepf.atod18.gestionStockInterne.persistance.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.afcepf.atod18.gestionStockInterne.commun.entitees.ProduitStockDto;

@Entity
@Table(name = "produitstock")
public class ProduitStock {

	/**
	 * Identifiant du produit
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * Quantité du produit dans le stock
	 */
	@Column(name = "quantiteStock")
	private Integer quantiteStock;

	/**
	 * Quantité minimal à partire de laquelle le stock doit être réaprovisionné
	 */
	@Column(name = "quantiteMinimal")
	private Integer quantiteMinimal;
	
	
	/** Constructeurs **/

	public ProduitStock() {
		super();
	}
	
	public ProduitStock(Integer paramId) {
		super();
		id = paramId;
	}
	
	public ProduitStock(Integer paramId, Integer paramQuantiteStock,
			Integer paramQuantiteMinimal) {
		super();
		id = paramId;
		quantiteStock = paramQuantiteStock;
		quantiteMinimal = paramQuantiteMinimal;
	}

	
	/** Getter setter **/

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public Integer getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(Integer paramQuantiteStock) {
		quantiteStock = paramQuantiteStock;
	}

	public Integer getQuantiteMinimal() {
		return quantiteMinimal;
	}

	public void setQuantiteMinimal(Integer paramQuantiteMinimal) {
		quantiteMinimal = paramQuantiteMinimal;
	}
	
	public ProduitStockDto toDto() {
		return new ProduitStockDto(id, quantiteStock, quantiteMinimal);
	}

}
