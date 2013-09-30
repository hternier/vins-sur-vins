package fr.afcepf.atod18.gestionFournisseur;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;
import fr.afcepf.atod18.gestionFournisseur.service.CommandeService;


@WebService (endpointInterface="fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService")
public class CommandesFournisseursServiceImpl implements CommandesFournisseursService {

	CommandeService commandeService;
	private static Logger logger = Logger.getLogger(CommandesFournisseursServiceImpl.class);
	
	@Override
	public Boolean passerCommande(Integer idProduit) {
		Boolean retour = commandeService.passerCommande(idProduit);
		logger.info("La méthode passercommande retourne  : " + retour);
		return retour;
	}
}
