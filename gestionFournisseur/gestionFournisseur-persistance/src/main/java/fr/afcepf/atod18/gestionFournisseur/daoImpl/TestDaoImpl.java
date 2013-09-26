package fr.afcepf.atod18.gestionFournisseur.daoImpl;

import org.springframework.stereotype.Repository;

import fr.afcepf.atod18.gestionFournisseur.bean.Test;
import fr.afcepf.atod18.gestionFournisseur.dao.TestDao;

@Repository
public class TestDaoImpl extends AbstractDAOImpl<Test, Integer> implements TestDao{

	public TestDaoImpl() {
		super(Test.class);
	}


}
