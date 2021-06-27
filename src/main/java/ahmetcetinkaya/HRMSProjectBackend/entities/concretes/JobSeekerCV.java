package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_cvs")
public class JobSeekerCV {
    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();

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

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVImage> images;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVWebSite> webSites;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVEducation> educations;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVExperience> experiences;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVSkill> skills;

    @OneToMany(mappedBy = "jobSeekerCV")
    private List<JobSeekerCVLanguage> languages;
}
