package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "mernis_activations")
public class MernisActivation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@JoinColumn(name = "user_id")
	@OneToOne()
	private User user;

	@NotNull
	@Column(name = "is_approved", columnDefinition = "boolean default false")
	private boolean isApproved = false;

	@NotNull
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@NotNull
	@PastOrPresent
	@Column(name = "approval_date")
	private LocalDateTime approvalDate;

	@Builder
	public MernisActivation(final int id, @NotNull final User user, @NotNull final boolean isApproved,
			@NotNull @PastOrPresent final LocalDateTime approvalDate) {
		this.id = id;
		this.user = user;
		this.isApproved = isApproved;
		this.approvalDate = approvalDate;
	}

}
