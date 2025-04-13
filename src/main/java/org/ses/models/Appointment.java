package org.ses.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter

@Document(collection = "appointment")
public class Appointment {
    @Id
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDateTime;
    private boolean approved;

    public Appointment() {}

    public Appointment(Patient patient, Doctor doctor, LocalDate appointmentDateTime, boolean approved) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.approved = false;
    }
}
