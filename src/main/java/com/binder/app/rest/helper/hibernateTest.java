package com.binder.app.rest.helper;

import java.util.List;


 




import org.hibernate.*;

import com.binder.app.entity.information;
import com.google.gson.Gson;
 
public class hibernateTest {
 
public static void main(String[] args) {
          
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
        
        information inf = new information();
        
        inf.setfName("sailesh");
        inf.setlName("b");
        inf.setGrade("A+");
        inf.setUniversity("colorado university, Bolder");
        
        Gson gson = new Gson();
        
        System.out.println(gson.toJson(inf));
        
        session.save(inf);
        session.getTransaction().commit();
        }
 
    }
    
