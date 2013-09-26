package fr.afcepf.atod18.gestionStockInterne.persistance.dao.impl;

import org.springframework.stereotype.Repository;

import fr.afcepf.atod18.gestionStockInterne.persistance.beans.ProduitStock;
import fr.afcepf.atod18.gestionStockInterne.persistance.dao.ProduitStockDao;

@Repository
public class ProduitStockDaoImpl extends AbstractDaoImpl<ProduitStock, Integer> implements ProduitStockDao {

	public ProduitStockDaoImpl() {
		super(ProduitStock.class);
	}
	

}
