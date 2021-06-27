package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeekerCV"})
@Entity
@Table(name = "job_seeker_cv_experiences")
public class JobSeekerCVExperience {
    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "job_seeker_cv_id")
    @ManyToOne
    private JobSeekerCV jobSeekerCV;

    @NotNull
    @JoinColumn(name = "job_position_id")
    @ManyToOne
    private JobPosition jobPosition;

    @NotBlank
    @Size(max = 100)
    @Column(name = "workplace_name")
    private String workplaceName;

    @NotNull
    @PastOrPresent
    @Column(name = "start_date")
    private LocalDate startDate;

    @PastOrPresent
    @Column(name = "quit_date")
    private LocalDate quitDate;
}