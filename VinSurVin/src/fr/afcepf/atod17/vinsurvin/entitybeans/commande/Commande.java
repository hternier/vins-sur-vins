package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.atod17.vinsurvin.entitybeans.compte.Adresse;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteAbstrait;

@Entity
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCommande")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateCommande")
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idCompte")
	private CompteAbstrait client;
	
	@ManyToOne
	@JoinColumn(name="idAdresseCommande")
	private Adresse adresseCommande;
	
	@ManyToOne
	@JoinColumn(name="idEtatCommande")
	private EtatCommande etatCommande;
	
	@ManyToOne
	@JoinColumn(name="idTarifLivraison")
	private TarifLivraison tarifLivraison;
	
	@OneToMany
	@JoinColumn(name="idCommande", referencedColumnName="idCommande")
	private List<ProduitEnCommande> produitsEnCommande;
	
	public Commande() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public CompteAbstrait getClient() {
		return client;
	}

	public void setClient(CompteAbstrait client) {
		this.client = client;
	}

	public Adresse getAdresseCommande() {
		return adresseCommande;
	}

	public void setAdresseCommande(Adresse adresseCommande) {
		this.adresseCommande = adresseCommande;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	public TarifLivraison getTarifLivraison() {
		return tarifLivraison;
	}

	public void setTarifLivraison(TarifLivraison tarifLivraison) {
		this.tarifLivraison = tarifLivraison;
	}

	public List<ProduitEnCommande> getProduitsEnCommande() {
		return produitsEnCommande;
	}

	public void setProduitsEnCommande(List<ProduitEnCommande> produitsEnCommande) {
		this.produitsEnCommande = produitsEnCommande;
	}
	
}
