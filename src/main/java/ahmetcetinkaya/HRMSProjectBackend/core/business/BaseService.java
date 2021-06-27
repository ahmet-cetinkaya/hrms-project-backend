package ahmetcetinkaya.HRMSProjectBackend.core.business;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import java.util.List;

public interface BaseService<T, Id> {
    Result add(T entity);

    Result delete(T entity);

    DataResult<List<T>> getAll();

    DataResult<T> getById(Id id);

    Result update(T entity);
}
