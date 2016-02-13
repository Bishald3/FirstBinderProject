package com.binder.app.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
	
		@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> list( List<String> nameList){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from UserInfo");
		@SuppressWarnings("unchecked")
		List<UserInfo> userList = query.list();
		
		 List<UserInfo> supplierNames1 = new ArrayList<UserInfo>();
		 nameList = new ArrayList<String>();
		for(UserInfo c: userList){
			supplierNames1.add(c);
			nameList.add(c.getfName());
		}
		System.out.println(nameList);
		return nameList;
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
	
	@RequestMapping("/userList")
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from UserInfo");
		@SuppressWarnings("unchecked")
		List<UserInfo> userList = query.list();
		String str = "lkajsdflk";
		
		req.setAttribute("product", userList); // Will be available as ${product} in JSP
        req.getRequestDispatcher("/WEB-INF/product.jsp").forward(req, res);

}}
