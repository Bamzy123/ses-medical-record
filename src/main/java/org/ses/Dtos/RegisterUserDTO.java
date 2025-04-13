package org.ses.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.ses.enums.Gender;
import org.ses.models.Address;

import java.time.LocalDate;

@Setter
@Getter
public class RegisterUserDTO {
    private String fullName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Address address;
    private String password;
    private String confirmPassword;
    private String userType;

    private String bloodType;
    private String allergies;
    private String diseases;
    private double weight;
    private double height;
    private String patientId;

    public RegisterUserDTO() {}
}