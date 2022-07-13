package com.example.springapplicaton.Models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Specialization")
public class Specialization {
    @Id
    private String specializationName;

    public Specialization(){}
    public Specialization(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
