package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {
        
       Configuration cgf = new Configuration();
       cgf.configure("hibernate.cfg.xml");
       SessionFactory factory = cgf.buildSessionFactory();

       //Creating Question
       Question q1 = new Question();
       q1.setQuestionId(2);
       q1.setQuestion("What is Java ?");
      
       // Creating Answer object
       Answer a1 = new Answer();
       a1.setAnswerId(324); 
       a1.setAnswer("Java is a programming language");

       q1.setAnswer(a1);
       Session s = factory.openSession();
       Transaction tx = s.beginTransaction();
       s.save(q1);
       tx.commit();

       //fetching
        Question newQ = (Question) s.get(Question.class, 2);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());




       factory.close();





    }
    
}
