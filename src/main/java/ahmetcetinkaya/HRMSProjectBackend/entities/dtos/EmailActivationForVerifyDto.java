package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailActivationForVerifyDto implements Dto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String activationCode;

    @Builder
    public EmailActivationForVerifyDto(@NotBlank @Email final String email, @NotBlank final String activationCode) {
        this.email = email;
        this.activationCode = activationCode;
    }
}
