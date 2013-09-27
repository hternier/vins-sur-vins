package fr.afcepf.atod18.gestionStockInterne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.persistance.dao.ProduitStockDao;

@Service
@Transactional(readOnly = true)
public class StockServiceImpl implements StockService {

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

}
