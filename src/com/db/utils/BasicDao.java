package com.db.utils;

import java.util.List;

public interface BasicDao {

	Object get(Class<?> clazz,final int id);
	
	boolean save(Object object);
	
	boolean delete(Class<?> clazz,int id);
	
	List<? extends Object> findAll(Class<?> clazz);
}
