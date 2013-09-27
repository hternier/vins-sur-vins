package fr.afcepf.atod18.gestionFournisseur;

import javax.jws.WebService;

import fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService;

@WebService (endpointInterface="fr.afcepf.atod18.gestionFournisseur.gestionFournisseurWS.CommandesFournisseursService")
public class CommandesFournisseursServiceImpl implements CommandesFournisseursService {


	@Override
	public Boolean passerCommande(Integer idProduit, Integer nombreProduits) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Integer getFournisseur(Integer idProduitStock) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
