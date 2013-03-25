package fr.afcepf.atod17.entitybeans.commande;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.afcepf.atod17.entitybeans.produit.Produit;

@Entity
@Table(name="ProduitCommande")
public class ProduitEnCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProduitEnCommandePK id;
	
	@Column(name="quantiteProduitCommande")
	private int quantite;
	
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false, name="idProduit")
	private Produit produit;
	
	public ProduitEnCommande() {
		
	}

	public ProduitEnCommandePK getId() {
		return id;
	}

	public void setId(ProduitEnCommandePK id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
