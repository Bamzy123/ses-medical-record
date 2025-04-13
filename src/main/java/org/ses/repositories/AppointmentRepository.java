package org.ses.repositories;

import org.ses.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    Optional<Appointment> findByDoctorEmailAndAppointmentDateTime(String doctor_email, LocalDate appointmentDateTime);
    List<Appointment> findByDoctorEmail(String doctor_email);

    LocalDate appointmentDateTime(LocalDate appointmentDateTime);
}
