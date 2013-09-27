package fr.afcepf.atod18.gestionFournisseur.daoImpl;

import org.springframework.stereotype.Repository;

import fr.afcepf.atod18.gestionFournisseur.bean.Produit;
import fr.afcepf.atod18.gestionFournisseur.dao.ProduitStockDao;

@Repository
public class ProduitStockDaoImpl extends AbstractDAOImpl<Produit, Integer> implements ProduitStockDao {

	public ProduitStockDaoImpl() {
		super(Produit.class);
	}

	/** Méthode de récupération de l'ID du fournisseur.**/
//	public Integer getFournisseur (Integer idProduit);

}
