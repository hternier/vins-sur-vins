package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.omg.CORBA.portable.InputStream;
import org.primefaces.event.FileUploadEvent;

import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanAjoutProduit extends AbstractManagedBean {

	private String listeTVASelected;
	private List<SelectItem> listeTVA;
	
	
	
	/**
	 * Constructeur par défaut
	 */
	public ManagedBeanAjoutProduit() {}

	/** Methode de gestion de la récupération de l'image dans la page d'ajout d'un produit **/
	 public void handleFileUpload(FileUploadEvent event) {
	        try {
	            File targetFolder = new File("/var/uploaded/images");
	            InputStream inputStream = (InputStream) event.getFile().getInputstream();
	            OutputStream out = new FileOutputStream(new File(targetFolder,
	                    event.getFile().getFileName()));
	            int read = 0;
	            byte[] bytes = new byte[1024];

	            while ((read = inputStream.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            }
	            inputStream.close();
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

		/** gestion de la liste de TVA **/	
		
		private void fillListeTVA() {
			List<SelectItem> liste = new ArrayList<SelectItem>();
			for (Double tva : getContext().getBean(ServiceProduitImpl.class).getAllTVA()) {				
				liste.add(new SelectItem(tva, String.valueOf(tva*100)));
				System.out.println("ajout d'un taux de tva");
			}
			this.listeTVA= liste;
		}
	
		/* ##################  GETTERS & SETTERS  ##################### */
		/**
		 * @return the listeTVASelected
		 */
		public String getListeTVASelected() {
			return listeTVASelected;
		}

		/**
		 * @return the listeTVA
		 */
		public List<SelectItem> getListeTVA() {
			return listeTVA;
		}

		/**
		 * @param paramListeTVASelected the listeTVASelected to set
		 */
		public void setListeTVASelected(String paramListeTVASelected) {
			listeTVASelected = paramListeTVASelected;
		}

		/**
		 * @param paramListeTVA the listeTVA to set
		 */
		public void setListeTVA(List<SelectItem> paramListeTVA) {
			fillListeTVA();
			listeTVA = paramListeTVA;
		}
}
