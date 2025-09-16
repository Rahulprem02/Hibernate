package com.map1;

import java.util.List;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Emp {

    @Id
    private int eid;
    private String ename;


    @ManyToMany
    private List<Project> projects;


    public int getEid() {
        return eid;
    }


    public void setEid(int eid) {
        this.eid = eid;
    }


    public String getEname() {
        return ename;
    }


    public void setEname(String ename) {
        this.ename = ename;
    }


    public List<Project> getProjects() {
        return projects;
    }


    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp() {
    }

    // ✅ Parameterized constructor
    public Emp(int eid, String ename, List<Project> projects) {
        this.eid = eid;
        this.ename = ename;
        this.projects = projects;
    }

   // ✅ toString()
    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", projects=" + (projects != null ? projects.size() : 0) + " projects" +
                '}';
    }
}