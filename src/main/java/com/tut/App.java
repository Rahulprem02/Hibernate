package com.tut;

import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started" );
       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
       Configuration cgf = new Configuration();
       cgf.configure("hibernate.cfg.xml");
       SessionFactory factory = cgf.buildSessionFactory();

       Student st = new Student();
       st.setId(10);
       st.setName("John"); 
       st.setCity("Karachi");

       System.out.println(st);

       Session session = factory.openSession();
       Transaction tx =  session.beginTransaction();
       session.save(st);
       tx.commit();
       session.close();
  
    }
}
