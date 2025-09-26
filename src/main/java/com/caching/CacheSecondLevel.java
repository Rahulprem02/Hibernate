package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;


public class CacheSecondLevel {

    public static void main(String[] args) {

      SessionFactory factory = new Configuration().configure().buildSessionFactory();
      Session session1 = factory.openSession();

      Student student1 = session1.get(Student.class,12424);
      //First level
      System.out.println(student1);

      session1.close();

      Session session2 = factory.openSession();

      Student student2 = session2.get(Student.class,12424);
      System.out.println(student2);

      factory.close();

    }
    
}
