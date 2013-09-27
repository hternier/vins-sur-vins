package fr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StockInterneService stockInterneService = ctx.getBean(StockInterneService.class);
//		ProduitStockDto produit = stockInterneService.getStock(1);
//		System.out.println(produit.getId());
//		System.out.println(produit.getQuantiteMinimal());
//		System.out.println(produit.getQuantiteStock());
		
		CommandesFournisseursService commandesFournisseursService = ctx.getBean(CommandesFournisseursService.class);
		System.out.println(commandesFournisseursService.ping("lala"));
	}

}
