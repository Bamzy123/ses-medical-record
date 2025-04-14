package org.ses.models;

import org.ses.enums.Gender;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "admins")
public class Admin extends User {

    public Admin(String fullName, String email, String phoneNumber, LocalDate dateOfBirth, Gender gender, Address address,
                 String password, String confirmPassword) {
        super(fullName, email, phoneNumber, dateOfBirth, gender, address, password, confirmPassword);
    }
}