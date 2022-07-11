package com.example.springapplicaton.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private LocalDate timeOfVisit;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> prescription;

    public Appointment(Doctor doctor, Patient patient, LocalDate timeOfVisit, List<String> prescription) {
        this.doctor = doctor;
        this.patient = patient;
        this.timeOfVisit = timeOfVisit;
        this.prescription = prescription;
    }
    public Appointment(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getTimeOfVisit() {
        return timeOfVisit;
    }

    public void setTimeOfVisit(LocalDate timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }

    public List<String> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<String> prescription) {
        this.prescription = prescription;
    }
}
