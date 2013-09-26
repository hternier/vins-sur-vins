package fr.afcepf.atod18.gestionFournisseur;

import javax.jws.WebService;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;

@WebService (endpointInterface="fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService")
public class CommandesFournisseursServiceImpl implements CommandesFournisseursService {

	@Override
	public String ping(String pong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getStock(Integer idProduitStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
