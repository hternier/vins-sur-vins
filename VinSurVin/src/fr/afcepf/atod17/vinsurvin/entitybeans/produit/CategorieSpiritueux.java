package fr.afcepf.atod17.vinsurvin.entitybeans.produit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class CategorieSpiritueux extends Categorie {

	private static final long serialVersionUID = 1L;

}
