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

import org.hibernate.validator.constraints.Length;

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
@Table(name = "job_seeker_web_sites")
public class JobSeekerWebSite {
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne
	private JobSeeker jobSeeker;

	@NotNull
	@JoinColumn(name = "web_site_id")
	@ManyToOne
	private WebSite webSite;

	@NotBlank
	@Length(max = 200)
	@Column(name = "address")
	private String address;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();
}
