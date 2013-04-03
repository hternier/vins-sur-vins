package fr.afcepf.atod17.vinsurvin.control.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Categorie;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.Produit;
import fr.afcepf.atod17.vinsurvin.entitybeans.produit.TVA;
import fr.afcepf.atod17.vinsurvin.services.implementations.ServiceProduitImpl;

public class ManagedBeanAjoutModifProduit extends AbstractManagedBean {

	private Integer listeTVASelected;
	private List<SelectItem> listeTVA;
	
	private Produit produit;
	private String listeCategoriesSelected;
	private Integer listeSousCategoriesSelected;
	
	private ManagedBeanGestionProduits mbGestionProduits;
	
	/**
	 * Constructeur par défaut
	 */
	public ManagedBeanAjoutModifProduit() {
	}
	

	/** Methode de gestion de la récupération de l'image dans la page d'ajout d'un produit **/
//	 public void handleFileUpload(FileUploadEvent event) {
//	        try {
//	            File targetFolder = new File("../resources/images/produits/");
//	            InputStream inputStream = (InputStream) event.getFile().getInputstream();
//	            OutputStream out = new FileOutputStream(new File(targetFolder,
//	                    event.getFile().getFileName()));
//	            int read = 0;
//	            byte[] bytes = new byte[1024];
//
//	            while ((read = inputStream.read(bytes)) != -1) {
//	                out.write(bytes, 0, read);
//	            }
//	            inputStream.close();
//	            out.flush();
//	            out.close();
//	            
//	            setImage(event.getFile().getFileName());
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
    
	 

		/** gestion de la liste de TVA **/	
		
		private void fillListeTVA() {
			List<SelectItem> liste = new ArrayList<SelectItem>();
			for (TVA tva : getContext().getBean(ServiceProduitImpl.class).getAllTVA()) {				
				liste.add(new SelectItem(tva.getId(), String.valueOf(tva.getValeur()*100)));
				System.out.println("ajout d'un taux de tva");
			}
			this.listeTVA= liste;
		}
		
		  public String getImage() {
		        String retour = "../resources/images/produits/noimage.jpg";
		        if (produit.getImage() != null && !produit.getImage().isEmpty()) {
		            retour = "../resources/images/produits/" + produit.getImage(); 
		        }
		        return retour;
		    }
		  
		  public String setImage(String paramImage) {
              System.out.println("Image : " + paramImage);
              return paramImage;
          }
		  
		  
		  
		  public String validerProduit() {
		      System.out.println("validationProduit");
		      
		      //Ajout de la sous-categorie
		      if(listeSousCategoriesSelected != null) {
		          System.out.println("validationProduit : sous-categorie select : " + listeSousCategoriesSelected.toString());
    	        Categorie categorie = produit.getCategorie();
    	        categorie.setId(listeSousCategoriesSelected);
    	        categorie = getContext().getBean(ServiceProduitImpl.class).getCategorie(categorie);
    	        produit.setCategorie(categorie);
		      }
		      
		      //Ajout TVA
		      if(listeTVASelected != null) {
		          System.out.println("validationProduit : TVA select : " + listeTVASelected);
	                //produit.setTva(listeTVASelected);
              }
		      
		      
		      //Persistance ou mise à jour du produit
		      if (produit.getId() == 0) {
		          System.out.println("validationProduit : persist");
		          produit = getContext().getBean(ServiceProduitImpl.class).ajoutProduit(produit);
		      } else {
		          System.out.println("validationProduit : merge");
		          produit = getContext().getBean(ServiceProduitImpl.class).setProduit(produit);
		      }
		      
            return "gestionProduit";
		  }
		  
		  public String annulerProduit() {
		      return "gestionProduit";
		  }
		

	
		/* ##################  GETTERS & SETTERS  ##################### */
		/**
		 * @return the listeTVASelected
		 */
		public Integer getListeTVASelected() {
			return listeTVASelected;
		}
		
        public void setListeTVASelected(Integer paramListeTVASelected) {
            System.out.println("setListeTVASelected :" + paramListeTVASelected);
            listeTVASelected = paramListeTVASelected;
        }
        
        
        /**
         * Sous catégorie sélectionné
         * @return
         */
        public Integer getListeSousCategoriesSelected() {
            return listeSousCategoriesSelected;
        }

        public void setListeSousCategoriesSelected(
                Integer paramListeSousCategoriesSelected) {
            System.out.println("setListeTVASelected :" + paramListeSousCategoriesSelected);

            listeSousCategoriesSelected = paramListeSousCategoriesSelected;
        }

		/**
		 * @return the listeTVA
		 */
		public List<SelectItem> getListeTVA() {
		    fillListeTVA();
			return listeTVA;
		}
		
		public void setListeTVA(List<SelectItem> paramListeTVA) {
			
			listeTVA = paramListeTVA;
		}

        public Produit getProduit() {
            if (produit == null) {
                produit = mbGestionProduits.getProduit();
                System.out.println("Récupération produit : " + produit.getCategoriePrimaire());
            }
            return produit;
        }

        public void setProduit(Produit paramProduit) {
            produit = paramProduit;
        }

        public String getListeCategoriesSelected() {
            return listeCategoriesSelected;
        }

        public void setListeCategoriesSelected(String paramListeCategoriesSelected) {
            listeCategoriesSelected = paramListeCategoriesSelected;
        }

        /**
         * Managed Bean Gestion produit
         */
        public ManagedBeanGestionProduits getMbGestionProduits() {
            return mbGestionProduits;
        }

        public void setMbGestionProduits(ManagedBeanGestionProduits paramMbGestionProduits) {
            mbGestionProduits = paramMbGestionProduits;
        }

       
        
}
