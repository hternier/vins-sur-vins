package fr.afcepf.atod18.gestionStockInterne.persistance.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

public interface AbstractDao<E, I extends Serializable> {

	E consulterParId (I id);
    void creerOuModifier (E e);
    void supprimer (E e);
    List<E> listerTous();
    Query creerQuery(String requete);
    Query creerQuerySQL(String requete);
}
