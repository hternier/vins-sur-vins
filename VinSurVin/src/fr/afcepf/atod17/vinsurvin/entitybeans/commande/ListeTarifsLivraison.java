package fr.afcepf.atod17.vinsurvin.entitybeans.commande;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;


import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceCommandeImpl;
import fr.afcepf.atod17.vinsurvin.services.interfaces.IServiceCommande;
import fr.afcepf.atod17.vinsurvin.utils.VinSurVinContext;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ListeTarifsLivraison extends ListDataModel<Object> implements SelectableDataModel<Object> {

    private IServiceCommande serviceCommande = VinSurVinContext.getSpringContext().getBean(ServiceCommandeImpl.class);
    
    public ListeTarifsLivraison() {
    }
    
	public ListeTarifsLivraison(List paramTarifsLivraison) {
        super(paramTarifsLivraison);
    }


    @Override
    public TarifLivraison getRowData(String paramRowKey) {
        TarifLivraison tarifRechercher = new TarifLivraison();
        tarifRechercher.setId(Integer.valueOf(paramRowKey));
        tarifRechercher = serviceCommande.getTarifLivraison(tarifRechercher);
        return tarifRechercher;
    }

    @Override
    public Object getRowKey(Object paramTarifLivraison) {
        return String.valueOf(paramTarifLivraison);
    }

    public IServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(IServiceCommande paramServiceCommande) {
        serviceCommande = paramServiceCommande;
    }
    
}
