package com.example.springapplicaton.Controllers;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Models.Specialization;
import com.example.springapplicaton.Repository.DoctorRepository;
import com.example.springapplicaton.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getDoctors(Model model){
        List<Doctor> doctors =  doctorService.getDoctors();
        model.addAttribute("doctors", doctors);
        return "doctorView/doctorList";
    }

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String getDoctorForm(Model model){
        List<Specialization> specializations = doctorService.getAllSpecialization();
        model.addAttribute("specializations", specializations);
        model.addAttribute("doctor", new Doctor());
        return "doctorView/doctorForm";
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/add")
    public String addNewDoctor(@ModelAttribute Doctor doctor){
        System.out.println(doctor.getFirstName());
        System.out.println("21312j23oi12joio2ij1");
        doctorService.addNewDoctor(doctor);
        return "redirect:/doctors";
    }

    @InitBinder("doctor")
    public void initBinderDoctor(WebDataBinder webDataBinder){
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
