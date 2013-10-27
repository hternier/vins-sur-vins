package fr.afcepf.atod17.vinsurvin.services.implementations;

import java.util.List;

import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.entitybeans.commande.Commande;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceStock;
import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;
import fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService;

public class ServiceStockImpl implements IServiceStock {

	private ControleDeStockService controleDeStockService;
	private IDaoCommande daoCommande;
	
	public void setControleDeStockService(
			ControleDeStockService paramControleDeStockService) {
		controleDeStockService = paramControleDeStockService;
	}

	public void setDaoCommande(IDaoCommande paramDaoCommande) {
		daoCommande = paramDaoCommande;
	}


	@Override
	public int getStockActuel(Produit paramProduit) {
		
		ProduitControleStock produitControleStock = new ProduitControleStock(paramProduit.getId());
		produitControleStock.setQuantite(0);
		return controleDeStockService.getStockActuel(produitControleStock);
	}

	@Override
	public boolean passerCommande(Commande paramCommande) {
		CommandeControleStock commandeControleStock = daoCommande.toCommandeControleStock(paramCommande);
		
		
		return controleDeStockService.passerCommande(commandeControleStock);
	}

	@Override
	public void ping(String paramString) {
		System.out.println(controleDeStockService.ping(paramString));
	}
	
	public List<Produit> getStockFormProductList(List<Produit> paramProduits)
	{
		for (Produit produit : paramProduits) {
			produit.setStock(getStockActuel(produit));
		}
		
		return paramProduits;
	}

}
