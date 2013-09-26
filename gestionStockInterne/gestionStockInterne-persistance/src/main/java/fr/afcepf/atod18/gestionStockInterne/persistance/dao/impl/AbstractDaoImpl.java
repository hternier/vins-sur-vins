package fr.afcepf.atod18.gestionStockInterne.persistance.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod18.gestionStockInterne.persistance.dao.AbstractDao;

public abstract class AbstractDaoImpl<E, I extends Serializable> implements
		AbstractDao<E, I> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<E> entityClasse;

	protected AbstractDaoImpl(Class<E> entityClasse) {
		this.entityClasse = entityClasse;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E consulterParId(I id) {
		return (E) getCurrentSession().get(entityClasse, id);
	}

	@Override
	public void creerOuModifier(E e) {
		getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public void supprimer(E e) {
		getCurrentSession().delete(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listerTous() {
		return getCurrentSession().createQuery(
				"From " + entityClasse.getSimpleName()).list();
	}

	@Override
	public Query creerQuery(String requete) {
		return getCurrentSession().createQuery(requete);
	}

	@Override
	public Query creerQuerySQL(String requete) {
		return getCurrentSession().createSQLQuery(requete);
	}

}
