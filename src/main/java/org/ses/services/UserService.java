package org.ses.services;

import org.ses.Dtos.LoginRequestDTO;
import org.ses.exceptions.UserNotFoundException;
import org.ses.models.User;
import org.ses.repositories.AdminRepository;
import org.ses.repositories.DoctorRepository;
import org.ses.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final AdminRepository adminRepository;

    public UserService(PatientRepository patientRepository, DoctorRepository doctorRepository, AdminRepository adminRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.adminRepository = adminRepository;
    }

    public User login(LoginRequestDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        String userType = loginDTO.getUserType().toUpperCase();

        return switch (userType) {
            case "PATIENT" -> patientRepository.findByEmail(email)
                    .filter(u -> u.getPassword().equals(password))
                    .orElseThrow(() -> new UserNotFoundException("Patient not found or invalid credentials."));
            case "DOCTOR" -> doctorRepository.findByEmail(email)
                    .filter(u -> u.getPassword().equals(password))
                    .orElseThrow(() -> new UserNotFoundException("Doctor not found or invalid credentials."));
            case "ADMIN" -> adminRepository.findByEmail(email)
                    .filter(u -> u.getPassword().equals(password))
                    .orElseThrow(() -> new UserNotFoundException("Admin not found or invalid credentials."));
            default -> throw new IllegalArgumentException("Unknown user type: " + userType);
        };
    }
}
