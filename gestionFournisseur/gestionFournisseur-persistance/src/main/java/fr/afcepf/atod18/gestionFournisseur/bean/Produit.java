package fr.afcepf.atod18.gestionFournisseur.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUIT")
public class Produit {
	
	@Id
	@Column (name="IDPRODUIT")
	private Integer id;
	
	@Column (name="QUANTITECOMMANDES", nullable=false)
	private Integer quantiteCommandee;	
	
	@ManyToOne
	@JoinColumn(name="IDFOURNISSEUR")
	private Fournisseur fournisseur;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the quantiteCommandee
	 */
	public Integer getQuantiteCommandee() {
		return quantiteCommandee;
	}

	/**
	 * @param quantiteCommandee the quantiteCommandee to set
	 */
	public void setQuantiteCommandee(Integer quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}

	/**
	 * @return the idFournisseur
	 */
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	/**
	 * @param fournisseur the idFournisseur to set
	 */
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	

}
