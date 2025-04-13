package org.ses.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentRequestDTO {
    private String patientEmail;
    private String doctorEmail;
    private LocalDateTime appointmentDateTime;

    public AppointmentRequestDTO() {}

    public AppointmentRequestDTO(String patientEmail, String doctorEmail, LocalDateTime appointmentDateTime) {
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
        this.appointmentDateTime = appointmentDateTime;
    }
}
