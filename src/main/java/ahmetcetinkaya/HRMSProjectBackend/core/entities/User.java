package ahmetcetinkaya.HRMSProjectBackend.core.entities;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Email
	@Size(max = 100)
	@Column(name = "email")
	private String email;

	@NotBlank
	@Size(max = 100)
	@Column(name = "password")
	@JsonIgnore
	private String password;

	@NotNull
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@NotNull
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@Builder
	public User(final int id, @NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

}
