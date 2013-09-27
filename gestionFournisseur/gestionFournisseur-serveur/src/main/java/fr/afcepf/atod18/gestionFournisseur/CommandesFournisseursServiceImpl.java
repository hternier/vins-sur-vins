package fr.afcepf.atod18.gestionFournisseur;

import javax.jws.WebService;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;
import fr.afcepf.atod18.gestionFournisseur.service.CommandeService;


@WebService (endpointInterface="fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService")
public class CommandesFournisseursServiceImpl implements CommandesFournisseursService {

	CommandeService commandeService;
	
	
	@Override
	public Boolean passerCommande(Integer idProduit) {
		Boolean retour = commandeService.passerCommande(idProduit);
		return retour;
	}
}
