package org.ses.services;

import org.ses.Dtos.RegisterUserDTO;
import org.ses.exceptions.ValidationException;
import org.ses.models.Admin;
import org.ses.repositories.AdminRepository;
import org.ses.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin registerAdmin(RegisterUserDTO dto) {
        if (!Validator.validateRegistration(dto)) {
            throw new ValidationException("Registration data is invalid.");
        }
        Admin admin = new Admin(
                dto.getFullName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getDateOfBirth(),
                dto.getGender(),
                dto.getAddress(),
                dto.getPassword(),
                dto.getConfirmPassword()
        );
        return adminRepository.save(admin);
    }

    // Admin-specific business logic
    public Admin approveAppointment(String appointmentId, boolean approval, AppointmentService appointmentService) {
        // Delegate to appointmentService (or write the logic here if required)
        appointmentService.approveAppointment(appointmentId, approval);
        // Return admin details or log the approval action.
        return adminRepository.findByEmail("admin@example.com").orElse(null);
    }
}
