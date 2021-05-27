package ahmetcetinkaya.HRMSProjectBackend.business.adapters.mernisService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForValidateFromMernisService {
	@NotNull
	private long TCKimlikNo;

	@NotBlank
	String ad;

	@NotBlank
	String soyad;

	@Past
	int dogumYili;
}
