package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User {
    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "identity_number")
    private String identityNumber;

    @NotNull
    @Past
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Builder(builderMethodName = "childBuilder")
    public JobSeeker(final int id, @NotBlank @Email @Size(max = 100) final String email,
                     @NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 50) final String firstName,
                     @NotBlank @Size(max = 50) final String lastName,
                     @NotBlank @Size(min = 11, max = 11) final String identityNumber, @NotNull @Past final LocalDate birthDate) {
        super(id, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }

}
