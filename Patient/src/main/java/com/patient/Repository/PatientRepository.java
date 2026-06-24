package com.patient.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	Optional<Patient>findByPatientid(Integer patientid);

}
