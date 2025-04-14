package org.ses.repositories;

import org.ses.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByDoctorEmailAndAppointmentDateTime(String doctor_email, LocalDateTime appointmentDateTime);

    List<Appointment> findByDoctorEmail(String doctorEmail);
}