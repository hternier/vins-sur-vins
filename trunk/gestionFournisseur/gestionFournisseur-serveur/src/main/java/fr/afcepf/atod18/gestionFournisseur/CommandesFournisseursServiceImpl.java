package fr.afcepf.atod18.gestionFournisseur;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;
import fr.afcepf.atod18.gestionFournisseur.service.CommandeService;


@WebService (endpointInterface="fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService")
public class CommandesFournisseursServiceImpl implements CommandesFournisseursService {

	@Autowired
	private CommandeService commandeService;
	
	private static Logger logger = Logger.getLogger(CommandesFournisseursServiceImpl.class);
	
	@Override
	public Boolean passerCommande(Integer idProduit) {
		logger.info("Entrée dans le webservice passerCommande");
		Boolean retour = commandeService.passerCommande(idProduit);
		if(retour){
			logger.info("La demande a bien été passée au fournisseur pour le produit : " + idProduit);
		}else {
			logger.error("La demande n'a pas pu être passée au fournisseur pour le produit : " + idProduit);
		}
		return retour;
	}
}
