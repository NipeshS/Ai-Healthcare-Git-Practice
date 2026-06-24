package com.patient.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.patient.DTO.PatientDto;
import com.patient.Entity.Patient;
import com.patient.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    // Register Patient
    @PostMapping("/register")
    public String save(@RequestBody PatientDto dto) {
        return service.save(dto);
    }

    // Get Patient By Id
    @GetMapping("/getById/{patientid}")
    public Patient get(@PathVariable Integer patientid) {
        return service.get(patientid);
    }

    // Get All Patients
    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }
}