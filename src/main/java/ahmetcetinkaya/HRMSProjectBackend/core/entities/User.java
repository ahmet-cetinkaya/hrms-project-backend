package ahmetcetinkaya.HRMSProjectBackend.core.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
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
	private String password;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@NotNull
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@NotNull
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@Builder
	public User(@NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password) {
		this.email = email;
		this.password = password;
	}

}
