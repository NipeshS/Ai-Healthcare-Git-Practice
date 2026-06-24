package Appointment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Appointment.DTO.AppointmentDto;
import Appointment.Entity.Appointment;
import Appointment.Service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // Book Appointment
    @PostMapping("/register")
    public String save(@RequestBody AppointmentDto dto) {
        return service.save(dto);
    }

    // Get Appointment By Id
    @GetMapping("/getById/{appointmentid}")
    public Appointment get(@PathVariable Integer appointmentid) {
        return service.get(appointmentid);
    }

    // Get All Appointments
    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }
}