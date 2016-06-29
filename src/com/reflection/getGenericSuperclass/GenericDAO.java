package com.reflection.getGenericSuperclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDAO<T> {

	private Class<T> entityClass;

	protected GenericDAO() {
		Class clazz = getClass();
		System.out.println(clazz);
		Type type = clazz.getGenericSuperclass();
		System.out.println(type);
		Type [] types = ((ParameterizedType) type).getActualTypeArguments();
		System.out.println(types);
		Type trueType = types[0];
		System.out.println(trueType);
		this.entityClass = (Class<T>) trueType;
	}

	public void outputEntityClass() {
		System.out.println("此类的超类是：" + entityClass);
	}
}
