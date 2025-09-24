package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class CacheSecondLevel {

    public static void main(String[] args) {
      SessionFactory factory =    new Configuration().configure().buildSessionFactory();
      Session session = factory.openSession();

      Student student = session.get(Student.class, 12424);
      System.out.println(student);

      System.out.println("Working student ");

      Student student1 = session.get(Student.class, 12424);
      System.out.println(student1);


      session.close();
      factory.close();

    }
    
}
