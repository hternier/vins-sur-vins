package testWebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;
import fr.afcepf.atod18.controleDeStock.ws.ControleDeStockService;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ControleDeStockService controleDeStockService = ctx.getBean("controleDeStockServicePourTest", ControleDeStockService.class);
		ProduitControleStock produit = new ProduitControleStock(1);
		produit.setQuantite(5);
		CommandeControleStock commande = new CommandeControleStock();
		commande.getProduits().add(produit);
		boolean salut = controleDeStockService.passerCommande(commande);
		System.out.println(salut);
	}
}
