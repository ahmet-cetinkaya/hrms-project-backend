package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "email_activations")
public class EmailActivation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@JoinColumn(name = "user_id")
	@ManyToOne()
	private User user;

	@NotBlank
	@Size(max = 200)
	@Column(name = "activation_code")
	private String activationCode;

	@NotBlank
	@Size(max = 100)
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "is_activated", columnDefinition = "boolean default false")
	private boolean isActivated = false;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@NotNull
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Builder
	public EmailActivation(@NotNull final User user, @NotBlank @Size(max = 200) final String activationCode,
			@NotBlank @Size(max = 100) final String email, @NotNull final boolean isActivated,
			@NotNull final LocalDateTime expirationDate, final LocalDateTime activationDate) {
		this.user = user;
		this.activationCode = activationCode;
		this.email = email;
		this.isActivated = isActivated;
		this.expirationDate = expirationDate;
		this.activationDate = activationDate;
	}

	@Builder
	public EmailActivation(@NotNull final User user, @NotBlank @Size(max = 200) final String activationCode,
			@NotBlank @Size(max = 100) final String email, @NotNull final LocalDateTime expirationDate,
			final LocalDateTime activationDate) {
		this.user = user;
		this.activationCode = activationCode;
		this.email = email;
		this.expirationDate = expirationDate;
		this.activationDate = activationDate;
	}
}