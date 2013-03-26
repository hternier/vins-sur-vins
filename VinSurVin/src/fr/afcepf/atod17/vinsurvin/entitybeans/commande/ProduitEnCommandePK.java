package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProduitEnCommandePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="idProduit")
	private int idProduit;
	
	@Column(name="idCommande")
	private int idCommande;
	
	public ProduitEnCommandePK() {
		
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	@Override
	public boolean equals(Object paramObj) {
		ProduitEnCommandePK pk = (ProduitEnCommandePK) paramObj;
		return (this.idCommande == pk.idCommande && this.idProduit == pk.idProduit);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
