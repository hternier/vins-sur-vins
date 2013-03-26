package fr.afcepf.atod17.entitybeans.produit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class CategorieAccessoire extends Categorie {

	private static final long serialVersionUID = 1L;

}
