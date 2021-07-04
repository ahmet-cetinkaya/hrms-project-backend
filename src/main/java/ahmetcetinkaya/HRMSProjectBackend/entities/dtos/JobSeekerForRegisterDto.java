package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.*;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class JobSeekerForRegisterDto implements Dto {
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
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Size(min = 11, max = 11)
	private String identityNumber;

	@NotNull
	@Past
	private LocalDate birthDate;
}
