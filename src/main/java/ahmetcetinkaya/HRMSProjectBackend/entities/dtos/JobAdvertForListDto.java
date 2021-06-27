package ahmetcetinkaya.HRMSProjectBackend.entities.dtos;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Dto;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class JobAdvertForListDto implements Dto {
    @NotBlank
    @Size(max = 100)
    private String companyName;

    @NotBlank
    @Size(max = 50)
    private String title;

    @Positive
    private int numberOfOpenPositions;

    @Past
    private LocalDateTime createdAt;

    @Future
    private LocalDateTime applicationDeadline;

    @PositiveOrZero
    private int minSalary;

    @PositiveOrZero
    private int maxSalary;
}
