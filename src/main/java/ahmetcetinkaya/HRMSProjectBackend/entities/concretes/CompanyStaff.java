package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "company_staffs")
@PrimaryKeyJoinColumn(name = "user_id")
public class CompanyStaff extends User {
	@NotBlank
	@Size(max = 50)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Size(max = 50)
	@Column(name = "last_name")
	private String lastName;

	@Builder(builderMethodName = "childBuilder")
	public CompanyStaff(final int id, final String email, final String password, final String firstName,
			final String lastName) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
