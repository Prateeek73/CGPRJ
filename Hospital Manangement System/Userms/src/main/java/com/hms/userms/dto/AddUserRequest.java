package com.hms.userms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
	@NotBlank(message = "First name is required")
	private String firstName;
	@NotBlank(message = "Last name is required")
	private String lastName;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
    @Pattern(regexp = "ADMIN|MANAGER|USER", message = "Role must be ADMIN or MANAGER or USER")
	private String role;
	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#])[a-zA-Z\\d@#]+$", message = "Password must include at least one uppercase letter, one lowercase letter, one digit, and one special symbol (@ or #).")
	private String password;
}