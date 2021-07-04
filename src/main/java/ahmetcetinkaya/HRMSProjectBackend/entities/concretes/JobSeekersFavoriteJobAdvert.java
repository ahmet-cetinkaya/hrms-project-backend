package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seekers_favorite_job_adverts")
public class JobSeekersFavoriteJobAdvert {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne
	private JobSeeker jobSeeker;

	@NotNull
	@JoinColumn(name = "job_advert_id")
	@ManyToOne
	private JobAdvert jobAdvert;
}
