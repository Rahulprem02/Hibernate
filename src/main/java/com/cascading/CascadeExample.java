package com.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();
        
        Question q1 = new Question();
        q1.setQuestionId(568);
        q1.setQuestion("What is Java ? ");

        Answer a1 = new Answer(23426,"Java Programming language");
        Answer a2 = new Answer(23427,"Java is OOP");
        Answer a3 = new Answer(23428,"Java reboust language");
        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);
        Transaction tx =  s.beginTransaction();
        s.save(q1);
       
        tx.commit();
        
        s.close();
        factory.close();
    }
    
}
