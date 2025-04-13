package org.ses.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDTO {
    private String email;
    private String password;
    private String userType;

    public LoginRequestDTO() {}

    public LoginRequestDTO(String email, String password, String userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}
