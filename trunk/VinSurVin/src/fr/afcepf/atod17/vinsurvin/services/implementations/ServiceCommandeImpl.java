package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod17.vinsurvin.control.managedbeans.AbstractManagedBean;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.compte.IDaoCompte;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.produit.IDaoProduit;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.EtatCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.ProduitEnCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.TarifLivraison;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCommande;

public class ServiceCommandeImpl extends AbstractManagedBean implements
		IServiceCommande {

	/**
	 * Instenciation de l'implémentation de la DAO commande.
	 */
	private IDaoCommande daoCommande;
	private IDaoCompte daoCompte;
	private IDaoProduit daoProduit;

	/**
	 * Constructeur par defaut.
	 */
	public ServiceCommandeImpl() {
	}

	@Override
	public Commande ajoutCommande(Commande paramCommande) {

		if (paramCommande.getAdresseCommande() != null
				&& paramCommande.getClient() != null
				&& paramCommande.getProduitsEnCommande() != null) {

			// Décrémentation du stock
			Produit produitEnStock;
			for (ProduitEnCommande pec : paramCommande.getProduitsEnCommande()) {
				produitEnStock = daoProduit.getProduit(pec.getProduit());
				int stockDispo = getContext().getBean(ServiceStockImpl.class).getStockActuel(produitEnStock);

				// if (pec.getQuantite() > produitEnStock.getStock()) {
				if (pec.getQuantite() > stockDispo) {
					System.err.println("Erreur de quantité commandé. Produit :"
							+ pec.getProduit().getLibelle()
							+ ", quantité désiré : "
							+ pec.getQuantite()
							+ ", quantité disponible : "
							+ stockDispo);
					paramCommande = new Commande();
					return paramCommande;
				} else {
					// Désactivation de la décrémentation du stock (utilisation
					// du WS)
					// produitEnStock.setStock(produitEnStock.getStock() -
					// pec.getQuantite());
					// daoProduit.setProduit(produitEnStock);
				}
			}

			// Affectation de la date
			paramCommande.setDateCommande(new Date());

			// Affectation du statut "En attente payement"
			EtatCommande etatCommande = new EtatCommande();
			etatCommande.setId(1);
			etatCommande = daoCommande.getEtatCommande(etatCommande);
			paramCommande.setEtatCommande(etatCommande);

			// Percistance de la commande
			paramCommande = daoCommande.addCommande(paramCommande);
			System.out.println("Création d'une commande : id : "
					+ paramCommande.getId() + ", id client : "
					+ paramCommande.getClient().getId());

		} else {
			paramCommande = new Commande();
			System.err
					.println("Création de commande impossible, il manque des informations !");
		}
		return paramCommande;
	}

	@Override
	public Commande validationCommande(Commande paramCommande) {
		// Il faut obligatoirement une adresse et un tarif de livraison.

		if (paramCommande.getAdresseCommande() != null) {
			if (paramCommande.getTarifLivraison() != null) {
				EtatCommande etatCommande = new EtatCommande();
				etatCommande.setId(2);
				etatCommande = daoCommande.getEtatCommande(etatCommande);
				paramCommande.setEtatCommande(etatCommande);

				paramCommande = daoCommande.setCommande(paramCommande);
				
				// Validation de la commande auprès du webservice
				boolean retourValidationCommande = getContext().getBean(
						ServiceStockImpl.class).passerCommande(paramCommande);
				if (retourValidationCommande) {
					System.out
							.println("Validation de la commande auprès du webservice");
				} else {
					System.err.println("Erreur validation de la commande.");
				}
			} else {
				System.err
						.println("Erreur validation commande : tarif de livraison inexistante");
			}
		} else {
			System.err
					.println("Erreur validation commande : adresse de livraison inexistante");
		}
		return paramCommande;
	}

	@Override
	public Commande annulerCommande(Commande paramCommande) {

		// Remise des produits dans le stock
		/*
		 * Produit produitEnStock; for (ProduitEnCommande pec :
		 * paramCommande.getProduitsEnCommande()) { produitEnStock =
		 * daoProduit.getProduit(pec.getProduit());
		 * 
		 * produitEnStock.setStock(produitEnStock.getStock() +
		 * pec.getQuantite()); daoProduit.setProduit(produitEnStock); }
		 */

		EtatCommande etatCommande = new EtatCommande();
		etatCommande.setId(6);
		etatCommande = daoCommande.getEtatCommande(etatCommande);
		paramCommande.setEtatCommande(etatCommande);

		paramCommande = daoCommande.setCommande(paramCommande);
		return paramCommande;
	}

	public List<TarifLivraison> getTarifLivraisonCommande(Commande paramCommande) {
		int totalUniteLivraison = 0;
		for (ProduitEnCommande pec : paramCommande.getProduitsEnCommande()) {
			totalUniteLivraison += (pec.getProduit().getUniteLivraison() * pec
					.getQuantite());
		}
		return daoCommande.getTarifLivraisonCommande(totalUniteLivraison);
	}

	@Override
	public List<Commande> rechercheCommande(Commande paramCommande) {
		return daoCommande.rechercheCommande(paramCommande);
	}

	@Override
	public Commande getCommande(Commande paramCommande) {
		return daoCommande.getCommande(paramCommande);
	}

	@Override
	public TarifLivraison getTarifLivraison(TarifLivraison paramTarifLivraison) {
		return daoCommande.getTarifLivraison(paramTarifLivraison);
	}

	/**
	 * Méthode de récupèration de la DAO commande.
	 * 
	 * @return La DAO produit
	 */
	public IDaoCommande getDaoCommande() {
		return daoCommande;
	}

	/**
	 * Méthode de définition de la DAO commande.
	 * 
	 * @param paramDaoProduit
	 *            La DAO commande
	 */
	public void setDaoCommande(IDaoCommande paramDaoCommande) {
		this.daoCommande = paramDaoCommande;
	}

	public IDaoCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDaoCompte paramDaoCompte) {
		daoCompte = paramDaoCompte;
	}

	public IDaoProduit getDaoProduit() {
		return daoProduit;
	}

	public void setDaoProduit(IDaoProduit paramDaoProduit) {
		daoProduit = paramDaoProduit;
	}

}
