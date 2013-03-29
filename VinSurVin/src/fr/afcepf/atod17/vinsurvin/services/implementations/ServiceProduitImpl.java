package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Prix;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceProduit;

/**
 * Implémentation du service Produit.
 * @author Hadrien TERNIER et Nicolas
 *
 */
public class ServiceProduitImpl implements IServiceProduit {

    /**
     * Instenciation de l'implémentation de la DAO produit.
     */
    private IDaoProduit daoProduit;

	/**
	 * Constructeur par defaut.
	 */
	public ServiceProduitImpl() {
		
	}

	/**
	 * Méthode de récupèration de la liste de tous les produits.
	 * @param enStock Defini si les produit doivent êtres en stock.
	 * @return La liste des produits
	 */
	public List<Produit> getAllProduit(boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllEnStock();
		} else {
			listeRetour = daoProduit.getAll();
		}
		return listeRetour;
	}

	@Override
	public List<String> getAllRegion(boolean enStock) {
		List<String> listeRetour = new ArrayList<String>();
		if (enStock) {
			//TODO Si besoin
		} else {
			listeRetour = daoProduit.getAllRegionAsString();
		}
		return listeRetour;
	}

	@Override
	public List<Produit> getAllProduitParNom(String paramNom, boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParNomEnStock(paramNom);
		} else {
			listeRetour = daoProduit.getAllParNom(paramNom);
		}
		return listeRetour;
	}

	/**
	 * Méthode de récupèration d'un produit par son Id.
	 * @param produit Le produit à récupérer.
	 * @return Le produit récupéré
	 */
	public Produit getProduit(Produit produit) {
		return daoProduit.getProduit(produit);
	}

	@Override
	public Double getPrixActuelTTC(Produit paramProduit) {
		Double retour = getPrixActuelHT(paramProduit);
		retour *= 1d + paramProduit.getTva().getValeur();
		return retour;
	}
	
	@Override
	public List<Produit> getAllProduitParPrix(double prixMin, double prixMax,
			boolean enStock) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllEnStock();
		} else {
			listeRetour = daoProduit.getAll();
		}
		this.filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}
	
	private void filterListeParPrix(List<Produit> paramListe, double prixMin, double prixMax) {
		Iterator<Produit> itProduit = paramListe.iterator();
		while (itProduit.hasNext()) {
			Produit p = itProduit.next();
			double prixP = this.getPrixActuelTTC(p);
			if (prixMin > prixP || prixMax < prixP) {
				itProduit.remove();
			}
		}
	}

	@Override
	public List<Produit> getAllProduitParPrixEtNom(double prixMin, double prixMax, boolean enStock, String paramNom) {
		List<Produit> listeRetour = null;
		if (enStock) {
			listeRetour = daoProduit.getAllParNomEnStock(paramNom);
		} else {
			listeRetour = daoProduit.getAllParNom(paramNom);
		}
		this.filterListeParPrix(listeRetour, prixMin, prixMax);
		return listeRetour;
	}

	 /**
     * Méthode de récupèration du prix actuel HT du produit.
     * @param paramProduit Le produit ayant un prix.
     * @return Le prix HT actuel
     */
	public Double getPrixActuelHT(Produit paramProduit) {
        for (Prix prix : paramProduit.getPrix()) {
            if(prix.getDateDebut().before(new Date()) && prix.getDateFin() == null) {
                return prix.getValeurHT();
            } else
            if(prix.getDateDebut().before(new Date()) && prix.getDateFin().after(new Date())) {
                return prix.getValeurHT();
            }
        }
        return null;
    }

	/**
	 * Méthode de récupèration de la DAO produit.
	 * @return Le DAO produit
	 */
	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	/**
	 * Méthode de définition de la DAO produit.
	 * @param paramDaoProduit La DAO produit
	 */
	public void setDaoProduit(IDaoProduit paramDaoProduit) {
		this.daoProduit = paramDaoProduit;
	}
}
