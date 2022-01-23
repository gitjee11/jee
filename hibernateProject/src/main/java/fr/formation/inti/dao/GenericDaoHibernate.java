package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;

public class GenericDaoHibernate<T, I extends Serializable> implements IGenericDao<T, I>{

	@Override
	public I save(T t) {
		
		return null;
	}

	@Override
	public void update(T t) {
		
		
	}

	@Override
	public void delete(I i) {
		
		
	}

	@Override
	public T findById(I i) {
		
		return null;
	}

	@Override
	public List<T> findAll() {
		
		return null;
	}

}
