package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {
    public static void main(String[] args) {
       System.out.println( "Project Started" );
       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
       Configuration cgf = new Configuration();
       cgf.configure("hibernate.cfg.xml");
       SessionFactory factory = cgf.buildSessionFactory();
       
        Session s = factory.openSession();
//HQL Syntax:
       String query = "from Student where city = 'ABC'" ;
        Query q = s.createQuery(query);
        //Single (Unique result)
    
        //q.uniqueResult()
        System.out.println(q.uniqueResult());
        //Multiple List
        // List<Student> list =  q.uniqueResult();


        // for(Student student : list){
        //     System.out.println(student.getName());
        // }


       s.close();
       factory.close();
    }
}
