package fr.afcepf.atod18.gestionStockInterne.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.persistance.dao.ProduitStockDao;

@Service
@Transactional(readOnly = true)
public class StockServiceImpl implements StockService {

	private static Logger logger = Logger.getLogger(StockServiceImpl.class);
	
	@Autowired
	private ProduitStockDao produitStockDao;

	@Override
	public ProduitStock getStock(ProduitStock paramProduit) {

		return produitStockDao.consulterParId(paramProduit.getId());
	}

	@Override
	public ProduitStock getStock(Integer paramIdProduit) {

		return produitStockDao.consulterParId(paramIdProduit);
	}

	@Override
	@Transactional(readOnly = false)
	public ProduitStock incrementeStock(Integer paramIdProduit,
			Integer paramQuantiteAjouter) {

		ProduitStock produit = produitStockDao.consulterParId(paramIdProduit);
		produit.setQuantiteStock(paramQuantiteAjouter
				+ produit.getQuantiteStock());

		produitStockDao.creerOuModifier(produit);

		return produit;
	}

	@Override
	@Transactional(readOnly = false)
	public ProduitStock decrementeStock(Integer paramIdProduit,
			Integer paramQuantiteRetirer) {
		logger.info("Décrément de stock pour le produit : " + paramIdProduit + ", pour une quantite de " + paramQuantiteRetirer);
		ProduitStock produit = produitStockDao.consulterParId(paramIdProduit);
		
		//Calcul du nouveau stock 
		Integer nouveauStock = produit.getQuantiteStock() - paramQuantiteRetirer;
		if (nouveauStock < 0) {
			nouveauStock = 0;
		}
		
		logger.info("Nouveau stock pour le produit " + paramIdProduit + " : " + nouveauStock);
		
		produit.setQuantiteStock(nouveauStock);
		produitStockDao.creerOuModifier(produit);
		
		logger.info("Nouveau stock mis à jour pour le produit " + paramIdProduit);

		return produit;
	}

}
