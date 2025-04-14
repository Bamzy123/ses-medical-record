package org.ses.validators;

import org.ses.Dtos.RegisterUserDTO;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    private static final Pattern emailRegex = Pattern.compile(EMAIL_PATTERN);

    public static boolean isEmailValid(String email) {
        return email != null && emailRegex.matcher(email).matches();
    }

    public static boolean isPasswordMatching(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }

    public static boolean validateRegistration(RegisterUserDTO dto) {
        return !isEmailValid(dto.getEmail()) || !isPasswordMatching(dto.getPassword(), dto.getConfirmPassword())
                || !isPhoneNumberValid(dto.getPhoneNumber());
    }
}
