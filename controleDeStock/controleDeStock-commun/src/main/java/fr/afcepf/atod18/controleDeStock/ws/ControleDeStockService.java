package fr.afcepf.atod18.controleDeStock.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.atod18.controleDeStock.entitees.CommandeControleStock;
import fr.afcepf.atod18.controleDeStock.entitees.ProduitControleStock;

@WebService
public interface ControleDeStockService {
	
	@WebMethod(operationName = "getInfoStock")
	public int getStockActuel(@WebParam(name = "produit")ProduitControleStock produit);

	@WebMethod(operationName = "verifierDisponibilite")
	public boolean verifierDisponibilite(@WebParam(name = "produit")ProduitControleStock produit, @WebParam(name = "quantiteStock")int quantiteStock);
	
	@WebMethod(operationName = "passerCommande")
	public boolean passerCommande(@WebParam(name = "commande")CommandeControleStock commande);
	
	@WebMethod(operationName = "ping")
	public String ping(@WebParam(name = "string")String string);
	
}
