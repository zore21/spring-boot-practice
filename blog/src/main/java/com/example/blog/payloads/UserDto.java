package com.example.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;

    @NotBlank
    @Size(min = 4, message = "USer name must be minimum of 4 characters")
    private String name;

    @Email(message = "given email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 10, message = "password must be in 4-10 long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

    @NotBlank
    private String about;

}
