package fr.afcepf.atod17.vinsurvin.dao.jpa.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.atod17.vinsurvin.dao.jpa.compte.DaoCompteImpl;
import fr.afcepf.atod17.vinsurvin.entitybeans.compte.CompteSysteme;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

public class TestDaoCompteJPA {
	
	private static DaoCompteImpl daoCompte;
	
	@BeforeClass
	public static void beforeClass() {
		daoCompte = VinSurVinContext.getSpringContext().getBean(DaoCompteImpl.class);
	}

	@Test
	public void testAuthentificationBO() {
		CompteSysteme cs = daoCompte.authentificationBO("interne", "afcepf");
		assertNotNull(cs);
	}

}
