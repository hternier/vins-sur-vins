package fr.afcepf.atod17.entitybeans.compte;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance
@DiscriminatorColumn(name="idTypeCompteCompte", discriminatorType=DiscriminatorType.INTEGER)
@Table(name="Compte")
public abstract class CompteAbstrait implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCompte")
	private int id;
	
	@Column(name="nomCompte")
	private String nom;
	
	@Column(name="prenomCompte")
	private String prenom;
	
	@Column(name="mailCompte")
	private String mail;
	
	@Column(name="mdpCompte")
	private String mdp;
	
	@Column(name="telCompte")
	private String tel;
	
	@Column(name="droitAccesCompte")
	private String droitAcces;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="derniereConnexionCompte")
	private Date derniereConnexion;
	
	@ManyToOne
	@JoinColumn(name="idEtatCompte")
	private EtatCompte etatCompte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDroitAcces() {
		return droitAcces;
	}

	public void setDroitAcces(String droitAcces) {
		this.droitAcces = droitAcces;
	}

	public Date getDerniereConnexion() {
		return derniereConnexion;
	}

	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}

	public EtatCompte getEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(EtatCompte etatCompte) {
		this.etatCompte = etatCompte;
	}
	
	
	
}
