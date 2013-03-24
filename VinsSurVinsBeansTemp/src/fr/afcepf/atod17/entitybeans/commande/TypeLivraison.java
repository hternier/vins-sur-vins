package fr.afcepf.atod17.entitybeans.commande;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TypeLivraison implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTypeLivraison")
	private int id;
	
	@Column(name="libelleTypeLivraison")
	private String libelle;
	
	@OneToMany
	@JoinColumn(name="idTypeLivraison", referencedColumnName="idTypeLivraison")
	private List<TarifLivraison> tarifsLivraison;
	
	public TypeLivraison() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<TarifLivraison> getTarifsLivraison() {
		return tarifsLivraison;
	}

	public void setTarifsLivraison(List<TarifLivraison> tarifsLivraison) {
		this.tarifsLivraison = tarifsLivraison;
	}
	
}
