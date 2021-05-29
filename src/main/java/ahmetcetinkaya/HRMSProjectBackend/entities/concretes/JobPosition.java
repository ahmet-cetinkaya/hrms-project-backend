package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "job_positions")
public class JobPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "title")
	private String title;

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
	public JobPosition(@NotBlank @Size(max = 50) final String title) {
		this.title = title;
	}

	@Builder
	public JobPosition(@NotBlank @Size(max = 50) final String title, @NotNull final boolean isActive,
			@NotNull final boolean isDeleted) {
		this.title = title;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}
}
