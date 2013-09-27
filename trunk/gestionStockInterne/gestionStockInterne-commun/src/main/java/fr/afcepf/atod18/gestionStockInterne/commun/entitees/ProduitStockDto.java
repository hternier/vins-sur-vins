package fr.afcepf.atod18.gestionStockInterne.commun.entitees;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entité pour la gestion de stock.
 * Utilisée pour les Web services.
 * @author Administrateur
 */
@XmlRootElement
public class ProduitStockDto implements Serializable {

	/**
	 * Permet de sérialiser.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identifiant du produit.
	 */
	private Integer id;

	/**
	 * Quantité du produit dans le stock.
	 */
	private Integer quantiteStock;

	/**
	 * Quantité minimale à partire de laquelle le stock doit être réaprovisionné.
	 */
	private Integer quantiteMinimale;
	
	
	/** Constructeurs **/

	public ProduitStockDto() {
		super();
	}
	
	public ProduitStockDto(Integer paramId) {
		super();
		id = paramId;
	}
	
	public ProduitStockDto(Integer paramId, Integer paramQuantiteStock,
			Integer paramQuantiteMinimal) {
		super();
		id = paramId;
		quantiteStock = paramQuantiteStock;
		quantiteMinimale = paramQuantiteMinimal;
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

	public Integer getQuantiteMinimale() {
		return quantiteMinimale;
	}

	public void setQuantiteMinimale(Integer paramQuantiteMinimale) {
		quantiteMinimale = paramQuantiteMinimale;
	}

}
