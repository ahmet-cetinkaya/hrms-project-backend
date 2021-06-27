package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_adverts")
public class JobAdvert {
    @PastOrPresent
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_TIMESTAMP")
    private final LocalDateTime createdAt = LocalDateTime.now();

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

    @Future
    @Column(name = "application_deadline")
    private LocalDateTime applicationDeadline;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted = false;
}