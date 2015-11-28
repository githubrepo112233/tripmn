package com.tripmn.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.tripmn.entity.BaseEntity;
import com.tripmn.repository.BaseRepositoryCustom;
import java.util.List;

public class BaseRepositoryImpl<T, ID extends Serializable> implements
		BaseRepositoryCustom<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")	
	public BaseRepositoryImpl() {
		this.persistentClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id, boolean lock) {
		T entity;
		if(lock){
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("javax.persistence.lock.timeout", 60000);
			properties.put("hibernate.cache.use_query_cache", false);
			CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getPersistentClass());
			Root<T> rootEntity = criteriaQuery.from(getPersistentClass());
			criteriaQuery.select(rootEntity);
			criteriaQuery.where(criteriaBuilder.equal(rootEntity.get("id"), id));
			TypedQuery<T> q = getEntityManager().createQuery(criteriaQuery);
			q.setLockMode(LockModeType.PESSIMISTIC_WRITE);
			List<T> obj = q.getResultList();
			entity = obj.get(0);
		}
		else{
			entity = (T)getEntityManager().find(getPersistentClass(), id);
		}
		return entity;
	}

	@Override
	public T makePersistent(T entity) {
		if(entity instanceof BaseEntity){
			BaseEntity entityObj = (BaseEntity) entity;
			Date date = Calendar.getInstance().getTime();
			if(entityObj.getVersion() == null){
				entityObj.setCreationTime(date);
				entityObj.setModifiedTime(date);
			}
			else{
				entityObj.setModifiedTime(date);
			}
		}
		getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public T merge(T entity) {
		if (entity instanceof BaseEntity) {
			BaseEntity entityObj = (BaseEntity) entity;
			Date date = Calendar.getInstance().getTime();
			entityObj.setModifiedTime(date);
			getEntityManager().persist(entity);
		}
		return entity;
	}
	
	@Override
	public void makeTransient(T entity) {
		getEntityManager().remove(entity);
		this.flush();
	}

	@Override
	public void flush() {
		getEntityManager().flush();
	}
	
	protected CriteriaQuery<T> createCriteriaQuery(){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getPersistentClass());		
		return criteriaQuery;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
}
