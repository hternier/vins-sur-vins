package fr.afcepf.atod17.entitybeans.compte;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class CompteSysteme extends CompteAbstrait {

	private static final long serialVersionUID = 1L;
	
	public CompteSysteme() {
		
	}

}
