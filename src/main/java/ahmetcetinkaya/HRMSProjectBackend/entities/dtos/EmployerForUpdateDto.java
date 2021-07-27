package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmployerForUpdateDto implements Dto {
	@NotNull
	private int employerId;

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

	@NotBlank
	@Size(max = 100)
	private String password;
}
