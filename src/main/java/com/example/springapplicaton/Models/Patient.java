package com.example.springapplicaton.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Patient")
public class Patient {

    @Id
    @Column(length = 11)
    private Long PESEL;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();

    public Patient(){

    }

    public Patient(Long PESEL, String firstName, String lastName) {
        this.PESEL = PESEL;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getPESEL() {
        return PESEL;
    }

    public void setPESEL(Long PESEL) {
        this.PESEL = PESEL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
