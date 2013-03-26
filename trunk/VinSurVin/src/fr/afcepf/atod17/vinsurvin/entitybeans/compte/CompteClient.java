package fr.afcepf.atod17.vinsurvin.entitybeans.compte;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;

@Entity
@DiscriminatorValue("1")
public class CompteClient extends CompteAbstrait {

	private static final long serialVersionUID = 1L;
	
	@Column(name="dateInscriptionCompte")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInscription;
	
	@ManyToOne
	@JoinColumn(name="idAdresseFacturationCompte")
	private Adresse adresseFacturation;
	
	@ManyToOne
	@JoinColumn(name="idAdresseLivraisonCompte")
	private Adresse adresseLivraison;
	
	@OneToMany
	@JoinColumn(name="idCompte", referencedColumnName="idCompte")
	private List<Commande> commandes;
	
	public CompteClient() {
		
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
