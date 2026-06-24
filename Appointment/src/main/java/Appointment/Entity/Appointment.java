package Appointment.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer appointmentid;
	
	
	private Integer patientid;
	
	private String doctorname;
	
	private String  appointmentdate;

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
}
