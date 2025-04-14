package org.ses.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter

@Document(collection = "appointment")
public class Appointment {
    @Id
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;
    private boolean approved;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, boolean approved) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.approved = false;
    }
}
