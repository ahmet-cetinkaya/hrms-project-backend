package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
@Entity
@Table(name = "working_types")
public class WorkingType {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @NotBlank
    @Length(max = 50)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "workingType")
    private List<JobAdvert> jobAdverts;
}
