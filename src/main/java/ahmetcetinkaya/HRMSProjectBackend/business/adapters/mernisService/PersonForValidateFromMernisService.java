package ahmetcetinkaya.HRMSProjectBackend.business.adapters.mernisService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonForValidateFromMernisService {
    @NotBlank
    String ad;
    @NotBlank
    String soyad;
    @Past
    int dogumYili;
    @NotNull
    private long TCKimlikNo;
}
