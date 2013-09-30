package fr.afcepf.atod18.gestionFournisseur.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod18.gestionFournisseur.bean.Produit;
import fr.afcepf.atod18.gestionFournisseur.dao.ProduitStockDao;
import fr.afcepf.atod18.gestionFournisseur.service.CommandeService;

@Service
@Transactional(readOnly = true)
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	ProduitStockDao produitDAO;

	@Override
	public Boolean passerCommande(Integer idProduit) {
		Boolean commandeValide = false;

		List<Produit> produits = produitDAO.listerTous();
		for (Produit produit : produits) {
			if (produit.getId().equals(idProduit)) {
				commandeValide = true;
			}
		}
		return commandeValide;

	}
}
