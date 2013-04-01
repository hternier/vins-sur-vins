package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import fr.afcepf.atod17.vinsurvin.dao.interfaces.commande.IDaoCommande;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCommande;

public class ListeTarifsLivraison extends ListDataModel<TarifLivraison> implements SelectableDataModel<TarifLivraison> {

    private IServiceCommande serviceCommande;
    
    public ListeTarifsLivraison() {
    }
    
    public ListeTarifsLivraison(List<TarifLivraison> paramTarifsLivraison) {
        super(paramTarifsLivraison);
    }


    @Override
    public TarifLivraison getRowData(String paramRowKey) {
        TarifLivraison tarifRechercher = new TarifLivraison();
//        tarifRechercher.setId(Integer.valueOf(paramRowKey));
//        System.out.println("getRowData : recherche : " + tarifRechercher.getId());
//        tarifRechercher = serviceCommande.getTarifLivraison(tarifRechercher);
//        System.out.println("getRowData : result : " + tarifRechercher.getId());
        return tarifRechercher;
    }

    @Override
    public Object getRowKey(TarifLivraison paramTarifLivraison) {
        System.out.println("getRowKey : " + String.valueOf(paramTarifLivraison.getId()));
        return String.valueOf(paramTarifLivraison.getId());
    }

    public IServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(IServiceCommande paramServiceCommande) {
        serviceCommande = paramServiceCommande;
    }
    
}
