package com.reflection.getGenericSuperclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDAO<T> {
	
	private Class<T> entityClass;

	protected GenericDAO() {
		Type type = getClass().getGenericSuperclass();
		System.out.println(type);
		Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
		System.out.println(trueType);
		this.entityClass = (Class<T>) trueType;
	}
	
	public void outputEntityClass(){
		System.out.println(entityClass);
	}
}
