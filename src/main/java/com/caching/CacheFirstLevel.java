package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheFirstLevel {

    public static void main(String[] args) {
      SessionFactory factory =    new Configuration().configure().buildSessionFactory();
      Session s = factory.openSession();

      s.close();
      factory.close();

    }
    
}
