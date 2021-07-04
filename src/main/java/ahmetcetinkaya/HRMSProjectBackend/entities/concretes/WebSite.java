package ahmetcetinkaya.HRMSProjectBackend.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "web_sites")
public class WebSite {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@NotBlank
	@Column(name = "name")
	private String name;
}
