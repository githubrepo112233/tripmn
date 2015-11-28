package com.tripmn.repository;

import java.io.Serializable;

public interface BaseRepository<T, ID extends Serializable> extends
		BaseRepositoryCustom<T, ID> {

	public T findOne(ID id);

	public Iterable<T> findAll();

	public Long count();

	public void delete(T entity);

	public boolean exists(ID primaryKey);
}
