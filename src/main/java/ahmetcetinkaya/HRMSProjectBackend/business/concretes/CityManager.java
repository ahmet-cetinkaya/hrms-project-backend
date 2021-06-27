package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CityService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.CityDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.City;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;

    @Autowired
    public CityManager(final CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(final City city) {
        cityDao.save(city);
        return new SuccessResult(Messages.cityAdded);
    }

    @Override
    public Result delete(final City city) {
        cityDao.delete(city);
        return new SuccessResult(Messages.cityDeleted);
    }

    @Override
    public DataResult<List<City>> getAll() {
        final List<City> cities = cityDao.findAll();
        return new SuccessDataResult<List<City>>(cities);
    }

    @Override
    public DataResult<City> getById(final Short id) {
        final Optional<City> city = cityDao.findById(id);

        if (city.isEmpty())
            return new ErrorDataResult<City>(Messages.cityNotFound);

        return new SuccessDataResult<City>(city.get());
    }

    @Override
    public DataResult<City> getByName(final String name) {
        final Optional<City> city = cityDao.findByName(name);

        if (city.isEmpty())
            return new ErrorDataResult<City>(Messages.cityNotFound);

        return new SuccessDataResult<City>(city.get());
    }

    @Override
    public DataResult<List<City>> getByNameContains(final String name) {
        final Optional<List<City>> city = cityDao.findByNameContains(name);

        return new SuccessDataResult<List<City>>(city.get());
    }

    @Override
    public Result update(final City city) {
        cityDao.save(city);
        return new SuccessResult(Messages.cityUpdated);
    }

}
