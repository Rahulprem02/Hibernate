package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        System.out.println("Pakistan"+ q.uniqueResult());
        //Multiple List
        // List<Student> list =  q.uniqueResult();


        // for(Student student : list){
        //     System.out.println(student.getName());
        // }

// Delete Query
        Transaction tx = s.beginTransaction();
        // Query q2  = s.createQuery("delete from Student where city = 'ABC'");

        // int r = q2.executeUpdate();
        // System.out.println("Deleted");
        // System.out.println(r);
    
//Update Query
        Query q2 = s.createQuery("Update Student set city=:c where name=:n");
        q2.setParameter("c","Delhi");
        q2.setParameter("n","Peter");
        int r = q2.executeUpdate();
        System.out.println(r + "Object Updated");
        

        tx  .commit();
        s.close();
        factory.close();

    }
}
