package ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

public interface BaseService<T, Id> {
	Result add(T entity);

	Result delete(Id id);

	DataResult<List<T>> getAll();

	DataResult<T> getById(Id id);

	Result update(T entity);
}
