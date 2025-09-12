package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        

      Configuration cgf = new Configuration();
      cgf.configure("hibernate.cfg.xml");
      SessionFactory factory = cgf.buildSessionFactory();
      Session session =factory.openSession();
        //get -10
      Student student = (Student) session.get(Student.class, 10);
      System.out.println("======"+student.getName());

      session.close();
      factory.close();
    }
    
}
