/**
 * 
 */
package fr.afcepf.atod18.gestionFournisseur.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author stagiaire
 *
 */
public class FournisseurTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		assertTrue(true);
		// une fois avant tous les tests (static)
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		assertNull(null);
		// une fois après tous les tests (static)
	}

	@Before
	public void setUp() throws Exception {
		assertNotNull("lala");
		// avant chaque test
	}

	@After
	public void tearDown() throws Exception {
		assertFalse("lala".equals("patate"));
		// après chaque test
	}

	@Test
	public void test() {
		assertTrue(true);
	}
	
}
