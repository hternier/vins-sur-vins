package fr.afcepf.atod18.gestionFournisseur.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FOURNISSEUR")
public class Fournisseur {

		@Id
		@Column (name="IDFOURNISSEUR")
		private Integer idFournisseur;
		
		@Column (name="LIBELLEFOURNISSEUR", nullable=false)
		private String libelleFournisseur;
		/**
		 * @return the idFournisseur
		 */
		public Integer getIdFournisseur() {
			return idFournisseur;
		}
		/**
		 * @param idFournisseur the idFournisseur to set
		 */
		public void setIdFournisseur(Integer idFournisseur) {
			this.idFournisseur = idFournisseur;
		}
		/**
		 * @return the libelleFournisseur
		 */
		public String getLibelleFournisseur() {
			return libelleFournisseur;
		}
		/**
		 * @param libelleFournisseur the libelleFournisseur to set
		 */
		public void setLibelleFournisseur(String libelleFournisseur) {
			this.libelleFournisseur = libelleFournisseur;
		}	
		
		
		

}
