package org.ses.models;

import lombok.Getter;
import lombok.Setter;
import org.ses.enums.Gender;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter

@Document(collection = "patients")
public class Patient extends User{
    private String bloodType;
    private String allergies;
    private String diseases;
    private double weight;
    private double height;
    private String patientId;
    private LocalDateTime lastVisit;
    private String prescription;
    private String testReport;

    public Patient(String fullName, String email, String phoneNumber, LocalDate dateOfBirth,
                   Gender gender, Address address, String password, String confirmPassword,
                   String bloodType, String allergies, String diseases, double height,
                   double weight, String patientId, LocalDateTime lastVisit,
                   String prescription, String testReport) {
        super(fullName, email, phoneNumber, dateOfBirth, gender, address, password, confirmPassword);
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.diseases = diseases;
        this.height = height;
        this.weight = weight;
        this.patientId = patientId;
        this.lastVisit = lastVisit;
        this.prescription = prescription;
        this.testReport = testReport;
    }
}
