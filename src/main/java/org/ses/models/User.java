package org.ses.models;

import lombok.Getter;
import lombok.Setter;
import org.ses.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Setter
@Getter
public abstract class User {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private LocalDate birthOfDate;

    @DBRef
    private Gender gender;

    @DBRef
    private Address address;
    private String password;
    private String confirmPassword;

    public User(String fullName, String email, String phoneNumber, LocalDate birthOfDate, Gender gender, Address address, String password, String confirmPassword) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthOfDate = birthOfDate;
        this.gender = gender;
        this.address = address;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
