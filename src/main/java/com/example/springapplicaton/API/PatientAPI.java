package com.example.springapplicaton.API;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Models.Patient;
import com.example.springapplicaton.Repository.DoctorRepository;
import com.example.springapplicaton.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientAPI {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/all")
    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    @GetMapping()
    public Patient getById(@RequestParam Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.get();
    }

    @PostMapping("/add")
    public boolean addPatient(@RequestBody Patient newPatient){
        patientRepository.save(newPatient);
        return true;
    }

    @PutMapping("/edit")
    public boolean updatePatient(@RequestBody Patient updatedPatient){
        patientRepository.save(updatedPatient);
        return true;
    }

    @DeleteMapping
    public boolean deletePatient(@RequestParam Long id){
        patientRepository.deleteById(id);
        return true;
    }
}
