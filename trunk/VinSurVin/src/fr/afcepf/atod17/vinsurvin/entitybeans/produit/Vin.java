package fr.afcepf.atod17.vinsurvin.entitybeans.produit;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Vin extends Produit {

	private static final long serialVersionUID = 1L;

	@Column(name="paysVinProduit")
	private String pays;
	
	@Column(name="regionVinProduit")
	private String region;
	
	@Column(name="appellationVinProduit")
	private String appelation;
	
	@Column(name="millesimeVinProduit")
	private String millesime;
	
	@Column(name="contenanceVinProduit")
	private int contenance;

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAppelation() {
		return appelation;
	}

	public void setAppelation(String appelation) {
		this.appelation = appelation;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public int getContenance() {
		return contenance;
	}

	public void setContenance(int contenance) {
		this.contenance = contenance;
	}
	
}
