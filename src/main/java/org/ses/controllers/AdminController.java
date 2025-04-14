package org.ses.controllers;

import org.ses.Dtos.RegisterUserDTO;
import org.ses.models.Admin;
import org.ses.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody RegisterUserDTO dto) {
        return adminService.registerAdmin(dto);
    }

    @PutMapping("/approve-appointment/{id}")
    public String approveAppointment(@PathVariable("id") String appointmentId, @RequestParam boolean approval,
                                     @Autowired org.ses.services.AppointmentService appointmentService) {
        appointmentService.approveAppointment(appointmentId, approval);
        return "Appointment " + appointmentId + " approval status changed to " + approval;
    }
}
