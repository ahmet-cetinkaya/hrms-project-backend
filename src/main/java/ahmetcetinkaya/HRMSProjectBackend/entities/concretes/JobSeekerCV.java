package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "job_seeker_cvs")
public class JobSeekerCV {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@OneToOne
	private JobSeeker jobSeeker;

	@Length(max = 300)
	@Column(name = "cover_letter")
	private String coverLetter;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVImage> images;

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVWebSite> webSites;

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVEducation> educations;

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVExperience> experiences;

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVSkill> skills;

	@JsonIgnore()
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVLanguage> languages;
}
