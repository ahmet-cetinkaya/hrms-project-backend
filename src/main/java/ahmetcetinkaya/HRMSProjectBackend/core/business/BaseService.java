package ahmetcetinkaya.HRMSProjectBackend.core.business;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

public interface BaseService<T> {
	Result add(T entity);

	Result delete(T entity);

	DataResult<List<T>> getAll();

	DataResult<T> getById(int id);

	Result update(T entity);
}
