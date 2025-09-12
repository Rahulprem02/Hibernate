package com.tut;

import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
       Configuration cgf = new Configuration();
       cgf.configure("hibernate.cfg.xml");
       SessionFactory factory = cgf.buildSessionFactory();

       Student st = new Student();
       st.setId(11);
       st.setName("Kumar"); 
       st.setCity("Hyderabad");
       System.out.println(st);


       Address ad = new Address();
       ad.setStreet("DesdernstraSe");
       ad.setCity("Leipzig");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(2);
       FileInputStream fis = new FileInputStream("src/main/java/asb.png");
       byte[] data = new byte[fis.available()];
       fis.read(data);
       ad.setImage(data);

       Session session = factory.openSession();
       Transaction tx =  session.beginTransaction();
       session.save(st);
       session.save(ad);

       tx.commit();
       session.close();
       System.out.println("Done");
  
    }
}
