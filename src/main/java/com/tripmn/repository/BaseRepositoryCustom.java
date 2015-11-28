package com.tripmn.repository;

import java.io.Serializable;

public interface BaseRepositoryCustom<T, ID extends Serializable> {
	public T findById(ID id, boolean lock);

	public T makePersistent(T entity);

	public void makeTransient(T entity);

	public T merge(T entity);

	public void flush();
}
