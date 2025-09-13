package com.tut;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;

    private Certificate cert;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    

    public Student()
    {

    }

   
    
public String toString() {
     return this.id + ":"+ this.name + ":"+ this.city;
}
public Certificate getCert() {
    return cert;
}
public void setCert(Certificate cert) {
    this.cert = cert;
}

    
    
}
