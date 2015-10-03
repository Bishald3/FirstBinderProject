package com.binder.app.test;


import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.binder.app.entity.UserInfo;
import com.binder.app.rest.helper.HibernateUtil;
import com.google.gson.Gson;
 
public class UserTest{
 
public static void main(String[] args) {
          
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
        
        UserInfo user = new UserInfo();
        
        user.setfName("ambar");
        user.setlName("rana");
        user.setPasswor("password");
        user.setUserName("arana");
        
        Gson gson = new Gson();
        
        System.out.println(gson.toJson(user));
        
        session.save(user);
        session.getTransaction().commit();
        
        // Data Access Object
        
		} 
    }
    

