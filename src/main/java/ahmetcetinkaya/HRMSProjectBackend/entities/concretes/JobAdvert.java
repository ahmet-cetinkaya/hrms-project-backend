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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
@Table(name = "job_adverts")
public class JobAdvert {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "employer_id")
	@ManyToOne()
	private Employer employer;

	@NotNull
	@JoinColumn(name = "job_position_id")
	@ManyToOne()
	private JobPosition jobPosition;

	@NotNull
	@JoinColumn(name = "city_id")
	@ManyToOne()
	private City city;

	@NotBlank
	@Column(name = "description")
	private String description;

	@PositiveOrZero
	@Column(name = "min_salary")
	private int minSalary;

	@PositiveOrZero
	@Column(name = "max_salary")
	private int maxSalary;

	@Positive
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@PastOrPresent
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_TIMESTAMP")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@Future
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@Builder
	public JobAdvert(@NotNull final Employer employer, @NotNull final JobPosition jobPosition, @NotNull final City city,
			@NotBlank final String description, @PositiveOrZero final int minSalary,
			@PositiveOrZero final int maxSalary, @Positive final int numberOfOpenPositions,
			@Future final LocalDateTime applicationDeadline) {
		this.employer = employer;
		this.jobPosition = jobPosition;
		this.city = city;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.applicationDeadline = applicationDeadline;
	}

}