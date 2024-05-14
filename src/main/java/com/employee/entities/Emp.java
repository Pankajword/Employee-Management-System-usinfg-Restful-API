package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String empName;
    private String company;
    private String city;

    public int getEmpId() {
        return id;
    }

    public void setEmpId(int empId) {
        this.id = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
}
