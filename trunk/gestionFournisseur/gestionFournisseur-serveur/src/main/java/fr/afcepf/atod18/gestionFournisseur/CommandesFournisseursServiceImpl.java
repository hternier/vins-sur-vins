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
		Boolean retour = commandeService.passerCommande(idProduit);
		logger.info("La méthode passerCommande retourne  : " + retour);
		return retour;
	}
}
