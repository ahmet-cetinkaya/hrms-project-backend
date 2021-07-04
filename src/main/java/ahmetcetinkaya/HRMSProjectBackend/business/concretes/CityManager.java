package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CityService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.CityDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.City;

@Service
public class CityManager extends BaseManager<CityDao, City, Short> implements CityService {
	private final CityDao cityDao;

	@Autowired
	public CityManager(final CityDao cityDao) {
		super(cityDao, "City");
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<City> getByName(final String name) {
		final Optional<City> city = cityDao.findByName(name);

		if (city.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("City"));

		return new SuccessDataResult<>(city.get());
	}

	@Override
	public DataResult<List<City>> getByNameContains(final String name) {
		final Optional<List<City>> city = cityDao.findByNameContains(name);

		return new SuccessDataResult<>(city.get());
	}
}
