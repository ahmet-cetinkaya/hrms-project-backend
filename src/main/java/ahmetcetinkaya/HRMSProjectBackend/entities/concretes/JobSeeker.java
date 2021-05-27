package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "job_seekers")
public class JobSeeker {

	@NotNull
	@Id
	@Column(name = "user_id")
	private int userId;

	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@Size(min = 11, max = 11, message = "The Identity Number must consist of 11 digits.")
	@Column(name = "identity_number")
	private String identityNumber;

	@Past
	@Column(name = "birth_date")
	private LocalDateTime birthDate;
}
