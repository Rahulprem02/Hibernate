package com.map1;

import java.util.List;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

    @Id
    private int pid;
    @Column(name="project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    // ✅ Default constructor (required by JPA)
    public Project() {
    }

    // ✅ Parameterized constructor
    public Project(int pid, String projectName, List<Emp> emps) {
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }


    @Override
public String toString() {
    return "Project{" +
            "pid=" + pid +
            ", projectName='" + projectName + '\'' +
            ", emps=" + (emps != null ? emps.size() : 0) + " employees" +
            '}';
}



    
}
