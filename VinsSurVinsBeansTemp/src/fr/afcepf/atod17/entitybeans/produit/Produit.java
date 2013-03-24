package fr.afcepf.atod17.entitybeans.produit;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance
@DiscriminatorColumn(name="idTypeProduit", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProduit")
	private int id;
	
	@Column(name="libelleProduit")
	private String libelle;
	
	@Column(name="stockProduit")
	private int stock;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateMiseEnLigneProduit")
	private Date dateMiseEnLigne;
	
	@Column(name="descriptionProduit")
	private String description;
	
	@Column(name="imageProduit")
	private String image;
	
	@Column(name="uniteLivraisonProduit")
	private int uniteLivraison;
	
	@ManyToOne
	@JoinColumn(name="idTVA")
	private TVA tva;
	
	@ManyToOne
	@JoinColumn(name="idCategorieProduit")
	private Categorie categorie;
	
	@OneToMany
	@JoinColumn(name="idProduit", referencedColumnName="idProduit")
	private List<Prix> prix;

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDateMiseEnLigne() {
		return dateMiseEnLigne;
	}

	public void setDateMiseEnLigne(Date dateMiseEnLigne) {
		this.dateMiseEnLigne = dateMiseEnLigne;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getUniteLivraison() {
		return uniteLivraison;
	}

	public void setUniteLivraison(int uniteLivraison) {
		this.uniteLivraison = uniteLivraison;
	}

	public TVA getTva() {
		return tva;
	}

	public void setTva(TVA tva) {
		this.tva = tva;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Prix> getPrix() {
		return prix;
	}

	public void setPrix(List<Prix> prix) {
		this.prix = prix;
	}
	
}
