package com.hibernate.v4.service;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hibernate.v4.domain.User;

@Service("userService")
public class UserService {
/*	@Autowired
    private HibernateTemplate hibernateTemplate;*/
	@Autowired
	private SessionFactory sessionFactory;
	
    @SuppressWarnings("unchecked")
	public List<User> getUserList(){
    	Session session = sessionFactory.getCurrentSession();
    	Criteria listCriteria = session.createCriteria(User.class);
    	List<User> list = listCriteria.list();
		/*listCriteria.setProjection(Projections.rowCount());
		Integer count = Integer.parseInt(listCriteria.uniqueResult().toString());*/
    	return list;
    }
    
    public Integer getRowCount(){
    	Integer count = 0;
    	Session session = sessionFactory.getCurrentSession();
    	Criteria listCriteria = session.createCriteria(User.class);
		listCriteria.setProjection(Projections.rowCount());
		count = Integer.parseInt(listCriteria.uniqueResult().toString());
    	return count;
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getUserListByHql(){
       	Session session = sessionFactory.getCurrentSession();
       	Query query = session.createQuery(" From User");
    	List<User> list = query.list();
    	return list;
    }
}
