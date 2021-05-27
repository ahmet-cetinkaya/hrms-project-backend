package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobSeekerForRegisterDto implements Dto {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Size(min = 11, max = 11, message = "The Identity Number must consist of 11 digits.")
	private String identityNumber;

	@Past
	private LocalDateTime birthDate;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;
}
