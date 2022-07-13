package com.example.springapplicaton.Service;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Models.Specialization;
import com.example.springapplicaton.Repository.DoctorRepository;
import com.example.springapplicaton.Repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long doctorId){
        return  doctorRepository.findById(doctorId).get();
    }

    public void addNewDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Specialization> getAllSpecialization(){
        return specializationRepository.findAll();
    }

}
