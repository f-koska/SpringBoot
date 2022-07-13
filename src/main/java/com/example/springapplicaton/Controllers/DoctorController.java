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
    public String getDoctorForm(Model model){
        List<Specialization> specializations = doctorService.getAllSpecialization();
        model.addAttribute("specializations", specializations);
        model.addAttribute("doctor", new Doctor());
        return "doctorView/doctorForm";
    }

    @PostMapping("/add")
    public String addNewDoctor(@ModelAttribute Doctor doctor){
        doctorService.addNewDoctor(doctor);
        return "redirect:/doctors";
    }

    @InitBinder("doctor")
    public void initBinderDoctor(WebDataBinder webDataBinder){
    }

}
