package org.ses.services;

import org.ses.Dtos.RegisterUserDTO;
import org.ses.exceptions.ValidationException;
import org.ses.models.Patient;
import org.ses.repositories.PatientRepository;
import org.ses.validators.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient registerPatient(RegisterUserDTO dto) {
        if (Validator.validateRegistration(dto)) {
            throw new ValidationException("Register data is invalid.");
        }
        Patient patient = new Patient(
                dto.getFullName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getDateOfBirth(),
                dto.getGender(),
                dto.getAddress(),
                dto.getPassword(),
                dto.getConfirmPassword(),
                dto.getBloodType(),
                dto.getAllergies(),
                dto.getDiseases(),
                dto.getHeight(),
                dto.getWeight(),
                dto.getPatientId(),
                LocalDateTime.now(),null, null
        );
    return patientRepository.save(patient);
    }
}