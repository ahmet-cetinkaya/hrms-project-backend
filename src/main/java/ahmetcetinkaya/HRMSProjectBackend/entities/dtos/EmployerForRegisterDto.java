package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmployerForRegisterDto implements Dto {
	@NotBlank
	@Email
	@Size(max = 100)
	private String email;

	@NotBlank
	@Size(max = 100)
	private String password;

	@NotBlank
	@Size(max = 100)
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

	@Builder
	public EmployerForRegisterDto(@NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 100) final String confirmPassword,
			@NotBlank @Size(max = 100) final String companyName, @NotBlank @Size(max = 100) final String website,
			@NotBlank @Size(max = 100) final String corporateEmail, @NotBlank @Size(max = 15) final String phone) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.companyName = companyName;
		this.website = website;
		this.corporateEmail = corporateEmail;
		this.phone = phone;
	}

}
