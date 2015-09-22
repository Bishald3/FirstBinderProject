package com.binder.app.action;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.binder.app.entity.*;
import com.binder.app.rest.helper.HibernateUtil;


public class Users {

	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	 
	public Users() {
		super();
	}
	public List<User> getUser()
	 
	{
	 
	Session s=sessionFactory.openSession();
	 
	
	//Get the data from database
	@SuppressWarnings("unchecked")
	List<User> user= s.createCriteria(User.class).list();
	 
	s.close();
	return user;
	 
	}
	 
	public User getStudent(long Id)
	 
	{
	 
	Session s=sessionFactory.openSession();
	 
	Criteria cr=s.createCriteria(User.class);
	 
	cr.add(Restrictions.eq("studentid", Id));
	 
	User user=(User) cr.list().get(0);
	 
	s.close();
	return user;
	 
	}
	
	//set method to alter the database
	
}
