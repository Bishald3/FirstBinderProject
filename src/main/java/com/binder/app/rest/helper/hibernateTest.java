package com.binder.app.rest.helper;

import java.util.List;

import org.hibernate.*;

import com.binder.app.entity.UserInfo;
import com.binder.app.entity.information;
import com.google.gson.Gson;
 
public class hibernateTest {
	public static void main( String[] args ){
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		 Query query = session.createQuery("from UserInfo where fName = :fName ");
	     query.setParameter("fName", "ambar");

	     List<?> list = query.list();

	     UserInfo list1 = (UserInfo)list.get(0);

	     System.out.println("ajdlfak" + list1.getfName());
		}
//public static void main(String[] args) {
//          
//        Session session = HibernateUtil.getSessionFactory().openSession();
//  
//        session.beginTransaction();
//        
//        information inf = new information();
//        
//        inf.setfName("Puru");
//        inf.setlName("Dai");
//        inf.setGrade("A+");
//        inf.setUniversity("colorado university, Bolder");
//        
//        UserInfo user = new UserInfo();
//        
//        user.setfName("ambar");
//        user.setlName("rana");
//        user.setPasswor("password");
//        user.setUserName("arana");
//        
//        Gson gson = new Gson();
//        
////        System.out.println(gson.toJson(inf));
//        
//        session.save(user);
//        session.save(inf);
//        session.getTransaction().commit();
//        
//        // Data Access Object
//        
//        
//        }
//
// 
    }
    
