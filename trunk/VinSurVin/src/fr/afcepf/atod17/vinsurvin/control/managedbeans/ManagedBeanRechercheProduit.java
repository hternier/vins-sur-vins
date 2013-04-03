package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import fr.afcepf.atod17.vinsurvin.control.entities.SpiritueuxVueRecherche;
import fr.afcepf.atod17.vinsurvin.control.entities.VinVueRecherche;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Accessoire;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Spiritueux;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Vin;

public class ManagedBeanRechercheProduit extends AbstractManagedBean {
	
	private ManagedBeanDetailProduit mbDetailProduit;
	private List<VinVueRecherche> listeVins = new ArrayList<VinVueRecherche>();
	private List<SpiritueuxVueRecherche> listeSpiritueux = new ArrayList<SpiritueuxVueRecherche>();
	private List<Accessoire> listeAccessoires = new ArrayList<Accessoire>();
	
	public ManagedBeanRechercheProduit() {
		
	}

	public List<VinVueRecherche> getListeVins() {
		return listeVins;
	}

	public void setListeVins(List<VinVueRecherche> listeVins) {
		this.listeVins = listeVins;
	}

	public List<SpiritueuxVueRecherche> getListeSpiritueux() {
		return listeSpiritueux;
	}

	public void setListeSpiritueux(List<SpiritueuxVueRecherche> listeSpiritueux) {
		this.listeSpiritueux = listeSpiritueux;
	}

	public List<Accessoire> getListeAccessoires() {
		return listeAccessoires;
	}

	public void setListeAccessoires(List<Accessoire> listeAccessoires) {
		this.listeAccessoires = listeAccessoires;
	}
	
	public ManagedBeanDetailProduit getMbDetailProduit() {
		return mbDetailProduit;
	}

	public void setMbDetailProduit(ManagedBeanDetailProduit mbDetailProduit) {
		this.mbDetailProduit = mbDetailProduit;
	}

	public void remplirListes (List<Produit> paramListe) {
		this.listeVins.clear();
		this.listeSpiritueux.clear();
		this.listeAccessoires.clear();
		for (Produit produit : paramListe) {
			String produitClass = produit.getClass().getName();
			if (produitClass.equals(Vin.class.getName())) {
				this.listeVins.add(new VinVueRecherche((Vin) produit));
			} else if (produitClass.equals(Spiritueux.class.getName())) {
				this.listeSpiritueux.add(new SpiritueuxVueRecherche((Spiritueux) produit));
			} else if (produitClass.equals(Accessoire.class.getName())) {
				this.listeAccessoires.add((Accessoire) produit);
			}
		}
	}
	
	public String showDetail() {
		System.out.println("J'y rentre");
		return "success";
	}
	
	public void loadDetailManagedBeanVin (ActionEvent ae) {
		VinVueRecherche p = (VinVueRecherche) ae.getComponent().getAttributes().get("produit");
		mbDetailProduit.setProduit(p.getVin());
	}
	
}
