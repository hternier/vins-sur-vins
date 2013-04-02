package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TarifLivraison implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTarifLivraison")
	private int id;
	
	@Column(name="societeTarifLivraison")
	private String societe;
	
	@Column(name="uniteLivraisonMinTarifLivraison")
	private int uniteLivraisonMin;
	
	@Column(name="uniteLivraisonMaxTarifLivraison")
	private int uniteLivraisonMax;
	
	@Column(name="tarifTarifLivraison")
	private double tarif;
	
	@ManyToOne
	@JoinColumn(name="idTypeLivraison")
	private TypeLivraison typeLivraison;
	
	public TarifLivraison() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public int getUniteLivraisonMin() {
		return uniteLivraisonMin;
	}

	public void setUniteLivraisonMin(int uniteLivraisonMin) {
		this.uniteLivraisonMin = uniteLivraisonMin;
	}

	public int getUniteLivraisonMax() {
		return uniteLivraisonMax;
	}

	public void setUniteLivraisonMax(int uniteLivraisonMax) {
		this.uniteLivraisonMax = uniteLivraisonMax;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public TypeLivraison getTypeLivraison() {
		return typeLivraison;
	}

	public void setTypeLivraison(TypeLivraison typeLivraison) {
		this.typeLivraison = typeLivraison;
	}

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
	
}
