package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import fr.afcepf.atod17.vinsurvin.control.entities.AccessoireVueRecherche;
import fr.afcepf.atod17.vinsurvin.control.entities.ProduitVueDetail;
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
	private List<AccessoireVueRecherche> listeAccessoires = new ArrayList<AccessoireVueRecherche>();
	
	public ManagedBeanRechercheProduit() {
		
	}

	public List<VinVueRecherche> getListeVins() {
		return listeVins;
	}

	public void setListeVins(List<VinVueRecherche> listeVins) {
		this.listeVins = listeVins;
	}
	
	public int getListeVinsLength() {
		return listeVins.size();
	}

	public List<SpiritueuxVueRecherche> getListeSpiritueux() {
		return listeSpiritueux;
	}

	public void setListeSpiritueux(List<SpiritueuxVueRecherche> listeSpiritueux) {
		this.listeSpiritueux = listeSpiritueux;
	}
	
	public int getListeSpiritueuxLength() {
		return listeSpiritueux.size();
	}

	public List<AccessoireVueRecherche> getListeAccessoires() {
		return listeAccessoires;
	}

	public void setListeAccessoires(List<AccessoireVueRecherche> listeAccessoires) {
		this.listeAccessoires = listeAccessoires;
	}
	
	public int getListeAccessoiresLength() {
		return listeAccessoires.size();
	}
	
	public ManagedBeanDetailProduit getMbDetailProduit() {
		return mbDetailProduit;
	}

	public void setMbDetailProduit(ManagedBeanDetailProduit mbDetailProduit) {
		this.mbDetailProduit = mbDetailProduit;
	}
	
	public boolean getAucunResultat() {
		return this.listeVins.isEmpty() && this.listeAccessoires.isEmpty() && this.listeSpiritueux.isEmpty();
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
				this.listeAccessoires.add(new AccessoireVueRecherche((Accessoire) produit));
			}
		}
	}
	
	public String showDetail() {
		return "success";
	}
	
	public void loadDetailManagedBeanVin (ActionEvent ae) {
		VinVueRecherche p = (VinVueRecherche) ae.getComponent().getAttributes().get("produit");
		mbDetailProduit.setProduit(new ProduitVueDetail(p.getVin()));
	}
	
	public void loadDetailManagedBeanSpiritueux (ActionEvent ae) {
		SpiritueuxVueRecherche p = (SpiritueuxVueRecherche) ae.getComponent().getAttributes().get("produit");
		mbDetailProduit.setProduit(new ProduitVueDetail(p.getSpiritueux()));
	}
	
	public void loadDetailManagedBeanAccessoire (ActionEvent ae) {
		AccessoireVueRecherche p = (AccessoireVueRecherche) ae.getComponent().getAttributes().get("produit");
		mbDetailProduit.setProduit(new ProduitVueDetail(p.getAccessoire()));
	}
	
}
