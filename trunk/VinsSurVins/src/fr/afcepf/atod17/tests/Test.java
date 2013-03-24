package fr.afcepf.atod17.tests;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.afcepf.atod17.entitybeans.compte.CompteAbstrait;
import fr.afcepf.atod17.entitybeans.compte.CompteClient;

@SuppressWarnings("unused")
public class Test {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VinsSurVins");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
//		//Test CompteClient
		CompteClient cpt = em.find(CompteClient.class, 1);
//		System.out.println(cpt.getId());
//		System.out.println(cpt.getMail());
//		System.out.println(cpt.getMdp());
//		System.out.println(cpt.getNom());
//		System.out.println(cpt.getPrenom());
//		System.out.println(cpt.getTel());
//		System.out.println(cpt.getDroitAcces());
//		System.out.println(sdf.format(cpt.getDateInscription()));
//		System.out.println(sdf.format(cpt.getDerniereConnexion()));
//		System.out.println(cpt.getEtatCompte().getLibelle());
//		System.out.println(cpt.getAdresseFacturation().equals(cpt.getAdresseLivraison()));
//		System.out.println(cpt.getAdresseFacturation().getVille().getVille());
		
//		//Test Query
//		Query hqlQuery = em.createQuery("From CompteAbstrait", CompteAbstrait.class);
//		List<CompteClient> liste = hqlQuery.getResultList();
//		System.out.println(liste.size());
		
		tx.commit();
		em.close();
		emf.close();
	}
	
}
