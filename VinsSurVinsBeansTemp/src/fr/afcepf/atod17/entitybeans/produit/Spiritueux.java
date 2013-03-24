package fr.afcepf.atod17.entitybeans.produit;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Spiritueux extends Produit {

	private static final long serialVersionUID = 1L;
	
	@Column(name="appellationSpiritueuxProduit")
	private String appellation;
	
	@Column(name="millesimeSpiritueuxProduit")
	private String millesime;
	
	@Column(name="degresSpiritueuxProduit")
	private String degres;
	
	@Column(name="contenanceSpiritueuxProduit")
	private int contenance;

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public String getDegres() {
		return degres;
	}

	public void setDegres(String degres) {
		this.degres = degres;
	}

	public int getContenance() {
		return contenance;
	}

	public void setContenance(int contenance) {
		this.contenance = contenance;
	}

}
