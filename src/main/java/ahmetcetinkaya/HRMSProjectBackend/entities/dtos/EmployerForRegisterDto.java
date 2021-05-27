package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.Data;

@Data
public class EmployerForRegisterDto implements Dto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String confirmPassword;

	@NotBlank
	@Size(max = 100)
	private String companyName;

	@NotBlank
	@Size(max = 100)
	private String website;

	@NotBlank
	@Size(max = 100)
	private String corporateEmail;

	@NotBlank
	@Size(max = 15)
	private String phone;
}
