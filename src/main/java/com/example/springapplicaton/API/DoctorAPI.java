package com.example.springapplicaton.API;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorAPI {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }

    @GetMapping()
    public Doctor getById(@RequestParam Long id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.get();
    }

    @PostMapping("/add")
    public boolean addDoctor(@RequestBody Doctor newDoctor){
    doctorRepository.save(newDoctor);
    return true;
    }

    @PutMapping("/edit")
    public boolean updateDoctor(@RequestBody Doctor updatedDoctor){
        doctorRepository.save(updatedDoctor);
        return true;
    }

    @DeleteMapping
    public boolean deleteDoctor(@RequestParam Long id){
       doctorRepository.deleteById(id);
        return true;
    }
}


