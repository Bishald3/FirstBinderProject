package com.binder.app.action;

import java.util.Iterator;
import java.util.List;

import com.binder.app.entity.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binder.app.rest.helper.HibernateUtil;

@Controller
public class Users {

	SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	 
	public Users() {
		super();
	}
	
	@RequestMapping("/user")
	static public void UserList(){
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Query query = session.createQuery("from UserInfo");
		@SuppressWarnings("unchecked")
		List<UserInfo> userList = query.list();
	   
		for(UserInfo list: userList){
			System.out.println(list.getfName());
		}
	}
}
