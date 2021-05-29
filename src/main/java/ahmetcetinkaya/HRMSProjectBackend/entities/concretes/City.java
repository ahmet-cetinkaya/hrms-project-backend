package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "cities")
public class City {
	@Id
	@Column(name = "id")
	private short id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "name")
	private String name;

	@Builder
	public City(final short id, @NotBlank @Size(max = 50) final String name) {
		this.id = id;
		this.name = name;
	}

}
