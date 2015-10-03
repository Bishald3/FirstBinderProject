package com.binder.app.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binder.app.entity.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.resteasy.specimpl.RequestImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.binder.app.rest.helper.HibernateUtil;

@SuppressWarnings("serial")
@Controller
public class Users extends HttpServlet{

	SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	
	Entity em;
	 
	public Users() {
		super();
	}
	
		@RequestMapping("/users")
	static public void UserList(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from UserInfo");
		@SuppressWarnings("unchecked")
		List<UserInfo> userList = query.list();
	   
		for(UserInfo list: userList){
			System.out.println(list.getfName());
		}
	}
	
	@RequestMapping("/user")
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		String fName= req.getParameter("fName");
		String lName = req.getParameter("lName");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		//add UserInfo table 
		UserInfo urs = new UserInfo();
		urs.setfName(fName);
		urs.setlName(lName);
		urs.setUserName(userName);
		urs.setPassword(password);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(urs);
		session.getTransaction().commit();
		session.close();
	}
}
