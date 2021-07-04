package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmailActivationForVerifyDto implements Dto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String activationCode;
}
