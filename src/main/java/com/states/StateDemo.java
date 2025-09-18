package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
    public static void main(String[] args) {
        System.out.println("Example");
    
        SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    
        // Create student object
        Student student = new Student();
        student.setId(122);
        student.setName("Peter");
        student.setCity("ABC");   

        student.setCert(new Certificate("Java Hibbernate", "2 month"));
        //Student : Transient 

        Session s = f.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        // Object associated with object and data insert 
        //Student : Persistent 

        student.setName("John");
        
        tx.commit();
        s.close();
        // Detached State session closed.
        student.setName("Adam");


        f.close();
    
    }
    
}
