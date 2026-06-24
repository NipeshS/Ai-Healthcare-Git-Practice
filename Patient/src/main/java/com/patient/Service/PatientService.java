package com.patient.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.DTO.PatientDto;
import com.patient.Entity.Patient;
import com.patient.Repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public String save(PatientDto dto) {

        Patient patient = new Patient();

        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setName(dto.getName());

        repo.save(patient);

        return "patient Registered Successfully";
    }

    public Patient get(Integer patientid) {

        Patient patient = repo.findByPatientid(patientid)
                .orElseThrow(() -> new RuntimeException("patient not found"));

        return patient;
    }

    // Get All Patients
    public List<Patient> getAllPatients() {
        return repo.findAll();
    }
}