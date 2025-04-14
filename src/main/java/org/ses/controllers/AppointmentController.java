package org.ses.controllers;

import org.ses.Dtos.AppointmentRequestDTO;
import org.ses.models.Appointment;
import org.ses.services.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody AppointmentRequestDTO dto) {
        return appointmentService.bookAppointment(dto);
    }
}
