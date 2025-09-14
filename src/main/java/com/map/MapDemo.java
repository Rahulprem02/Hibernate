package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

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
       a1.setAnswerId(326); 
       a1.setAnswer("Java is a programming language");
      // q1.setAnswer(a1);


       Answer a2 = new Answer();
       a2.setAnswerId(327); 
       a2.setAnswer("Java is a OOP language");
      // q1.setAnswer(a2);


       List<Answer> list = new ArrayList<>();
       list.add(a1);
       list.add(a2);

       q1.setAnswers(list);


       Session s = factory.openSession();
       Transaction tx = s.beginTransaction();
    //    s.save(q1);
    //    s.save(a1);
    //    s.save(a2);
    //    tx.commit();

    Question q = (Question) s.get(Question.class, 2);
    System.out.println(q.getQuestion());

    for(Answer a : q.getAnswers()){
        System.out.println(a.getAnswer());
    }



    //    //fetching
    //     Question newQ = (Question) s.get(Question.class, 2);
    //     System.out.println(newQ.getQuestion());
    //     System.out.println(newQ.getAnswer().getAnswer());




       factory.close();





    }
    
}
