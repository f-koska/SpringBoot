package com.example.springapplicaton.Controllers;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Repository.DoctorRepository;
import com.example.springapplicaton.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping()
    public String getDoctors(Model model){
        List<Doctor> doctors =  doctorService.getDoctors();
        model.addAttribute("doctors", doctors);
        return "doctorView/doctorList";
    }


    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/add")
    public void addNewDoctor(@RequestBody Doctor doctor){
        doctorService.addNewDoctor(doctor);
    }

//    @PutMapping("/edit/{doctorId}")
//    public void updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor updatedDoctor){
//        Doctor doctor = doctorRepository.findById(doctorId).get();
//
//        if(doctor!=null){
//            doctor.setFirstName(updatedDoctor.getFirstName());
//            doctor.setLastName(updatedDoctor.getLastName());
//            doctor.setSalary(updatedDoctor.getSalary());
//
//            doctorRepository.save(doctor);
//        }
//
//    }


}
