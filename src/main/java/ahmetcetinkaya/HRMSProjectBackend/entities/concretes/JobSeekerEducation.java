package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDate;
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
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_educations")
public class JobSeekerEducation {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne
	private JobSeeker jobSeeker;

	@NotBlank
	@Size(max = 100)
	@Column(name = "school_name")
	private String schoolName;

	@NotBlank
	@Size(max = 100)
	@Column(name = "department_name")
	private String departmentName;

	@NotNull
	@PastOrPresent
	@Column(name = "start_date")
	private LocalDate startDate;

	@PastOrPresent
	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();
}