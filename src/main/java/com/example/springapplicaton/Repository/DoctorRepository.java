package com.example.springapplicaton.Repository;

import com.example.springapplicaton.Models.Doctor;
import com.example.springapplicaton.Models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    @Query("SELECT d FROM Doctor d where d.specialization = ?1")
    List<Doctor> findDoctorBySpecialization(String specialization);
}
