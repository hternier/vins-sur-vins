package fr.afcepf.atod17.entitybeans.produit;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Accessoire extends Produit {

	private static final long serialVersionUID = 1L;
	
	@Column(name="marqueAccessoireProduit")
	private String marque;
	
	@Column(name="poidsAccessoireProduit")
	private int poids;

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

}
