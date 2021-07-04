package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.City;

public interface CityService extends BaseService<City, Short> {
	DataResult<City> getByName(String name);

	DataResult<List<City>> getByNameContains(String name);
}
