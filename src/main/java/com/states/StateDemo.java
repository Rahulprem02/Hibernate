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
        // Student student = new Student();
        // student.setId(122);
        // student.setName("Peter");
        // student.setCity("ABC");   

        // student.setCert(new Certificate("Java Hibbernate", "2 month"));


        Student student1 = new Student();
        student1.setId(120);
        student1.setName("Peter");
        student1.setCity("Karachi");   

        student1.setCert(new Certificate("Python", "3 month"));
        //Student : Transient 

        Session s = f.openSession();
        Transaction tx = s.beginTransaction();
        // s.save(student);
        s.save(student1);
        // Object associated with object and data insert 
        //Student : Persistent 

       
        
        tx.commit();
        s.close();
        // Detached State session closed.


        f.close();
    
    }
    
}
