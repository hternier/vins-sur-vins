package fr.afcepf.atod18.gestionFournisseur.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod18.gestionFournisseur.dao.ProduitStockDao;
import fr.afcepf.atod18.gestionFournisseur.service.StockService;

@Service
@Transactional(readOnly=true)
public class StockServiceImpl implements StockService {
	
	@Autowired
	private ProduitStockDao produitStockDao;
	
//	public Fournisseur ObtenirFournisseur (Integer id){
//		produitStockDao.consulterParId(id);
//	}

}
