package Appointment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Appointment.DTO.AppointmentDto;
import Appointment.DTO.PatientDto;
import Appointment.Entity.Appointment;
import Appointment.Repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    // Book Appointment
    public String save(AppointmentDto dto) {

        PatientDto patient = restTemplate.getForObject(
                "http://localhost:8082/patient/getById/" + dto.getPatientid(),
                PatientDto.class);xx 

        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }

        Appointment appointment = new Appointment();

        appointment.setPatientid(dto.getPatientid());
        appointment.setDoctorname(dto.getDoctorname());
        appointment.setAppointmentdate(dto.getAppointmentdate());

        repo.save(appointment);

        return "Appointment Booked Successfully";
    }

    // Get Appointment By Id
    public Appointment get(Integer appointmentid) {

        return repo.findById(appointmentid)
                .orElseThrow(() ->
                        new RuntimeException("Appointment not found"));
    }

    // Get All Appointments
    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }
}