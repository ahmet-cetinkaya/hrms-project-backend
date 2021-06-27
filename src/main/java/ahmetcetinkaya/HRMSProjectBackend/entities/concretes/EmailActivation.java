package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "email_activations")
public class EmailActivation {
    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne()
    private User user;

    @NotBlank
    @Size(max = 200)
    @Column(name = "activation_code")
    private String activationCode;

    @NotBlank
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "is_activated", columnDefinition = "boolean default false")
    private boolean isActivated = false;

    @NotNull
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "activation_date")
    private LocalDateTime activationDate;
}