package ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<TEntityService extends BaseService<TEntity, TEntityId>, TEntity, TEntityId> {
    private TEntityService entityService;

    public BaseController(final TEntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody @Valid final TEntity entity) {
        final Result result = entityService.add(entity);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<Result> delete(@RequestBody final TEntity entity) {
        final Result result = entityService.delete(entity);

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<TEntity>>> getAll() {
        final DataResult<List<TEntity>> result = entityService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/byid")
    public ResponseEntity<DataResult<TEntity>> getById(final TEntityId id) {
        final DataResult<TEntity> result = entityService.getById(id);

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Result> update(@RequestBody @Valid final TEntity entity) {
        final Result result = entityService.update(entity);

        return ResponseEntity.ok(result);
    }
}
