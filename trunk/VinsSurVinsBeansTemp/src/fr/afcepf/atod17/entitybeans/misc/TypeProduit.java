package fr.afcepf.atod17.entitybeans.misc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeProduit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTypeProduit")
	private int id;
	
	@Column(name="libelleTypeProduit")
	private String libelleTypeProduit;

	public TypeProduit() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleTypeProduit() {
		return libelleTypeProduit;
	}

	public void setLibelleTypeProduit(String libelleTypeProduit) {
		this.libelleTypeProduit = libelleTypeProduit;
	}
	
}
