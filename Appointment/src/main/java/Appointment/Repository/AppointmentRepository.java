package Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Appointment.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

}
