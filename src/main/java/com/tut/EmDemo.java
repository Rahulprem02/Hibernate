package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import org.hibernate.Session;


public class EmDemo {

    public static void main(String[] args) {
        
       System.out.println( "Project Started" );
       Configuration cgf = new Configuration();
       cgf.configure("hibernate.cfg.xml");
       SessionFactory factory = cgf.buildSessionFactory();

       Student student1 =new Student();

       student1.setId(12);
       student1.setName("Bhagesh"); 
       student1.setCity("Umerkot");

       Certificate certificate1 = new Certificate();

       certificate1.setCourse("Python");
       certificate1.setDuration("2 months");

       student1.setCert(certificate1);
       
       Session s = factory.openSession();
       Transaction tx = s.beginTransaction();

       s.save(student1);

       tx.commit();
       s.close();
       factory.close();

    }
    
}
