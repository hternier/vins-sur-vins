package fr.afcepf.atod18.gestionFournisseur.service.impl;

import org.apache.log4j.Logger;
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

	private static Logger logger = Logger.getLogger(CommandeServiceImpl.class);
	
	@Override
	public Boolean passerCommande(Integer idProduit) {
		Boolean commandeValide = false;

		Produit produit = produitDAO.consulterParId(idProduit);
		 if (produit!=null && produit.getFournisseur()!=null) {
			 logger.info("Commande passée pour le produit " + idProduit + " au fournisseur " + produit.getFournisseur().getLibelleFournisseur());
			 commandeValide = true;
		 }
		 else{
			 logger.error("Produit ou fournisseur inexistant");
		 }
		
		return commandeValide;
	}
	
}
