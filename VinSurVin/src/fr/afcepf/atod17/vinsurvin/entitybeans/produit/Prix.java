package fr.afcepf.atod17.vinsurvin.entitybeans.produit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prix implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPrix")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateDebutPrix")
	private Date dateDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateFinPrix")
	private Date dateFin;
	
	@Column(name="valeurHTPrix")
	private double valeurHT;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getValeurHT() {
		return valeurHT;
	}

	public void setValeurHT(double valeurHT) {
		this.valeurHT = valeurHT;
	}

}
