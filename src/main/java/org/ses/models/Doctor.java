package org.ses.models;

import lombok.Getter;
import lombok.Setter;
import org.ses.enums.Gender;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter

@Document(collection = "doctors")
public class Doctor extends User{
    private String speciality;

    public Doctor(String fullName, String email, String phoneNumber, LocalDate dateOfBirth, Gender gender, Address address,
                  String password, String confirmPassword, String specialization) {
        super(fullName, email, phoneNumber, dateOfBirth, gender, address, password, confirmPassword);
        this.speciality = specialization;
    }
}
