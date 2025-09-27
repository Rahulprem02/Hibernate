package com.mappingXML;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class Test {
    public static void main(String[] args) {
       SessionFactory  factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       
       Person person = new Person(23, "Rahul","karachi","2233");

       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();

       session.save(person);


       tx.commit();
       session.close();
       factory.close();
    }
    
}
