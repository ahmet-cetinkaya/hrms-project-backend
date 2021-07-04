package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cities")
public class City {
	@Column(name = "id")
	@Id
	private short id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "name")
	private String name;
}
