package fr.afcepf.atod18.gestionFournisseur.daoImpl;

import org.springframework.stereotype.Repository;

import fr.afcepf.atod18.gestionFournisseur.bean.ProduitStock;
import fr.afcepf.atod18.gestionFournisseur.dao.ProduitStockDao;

@Repository
public class ProduitStockDaoImpl extends AbstractDAOImpl<ProduitStock, Integer> implements ProduitStockDao {

	public ProduitStockDaoImpl() {
		super(ProduitStock.class);
	}

	/** Méthode de récupération de l'ID du fournisseur.**/
//	public Integer getFournisseur (Integer idProduit);

}
