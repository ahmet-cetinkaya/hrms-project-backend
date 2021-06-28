package ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.City;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseManager<TEntityDao extends JpaRepository<TEntity, TEntityId>, TEntity, TEntityId> implements BaseService<TEntity, TEntityId> {
    private final TEntityDao entityDao;
    private final Messages entityMessages;

    public BaseManager(final TEntityDao tEntityDao, String entityName) {
        this.entityDao = tEntityDao;
        this.entityMessages = new Messages(entityName);
    }

    @Override
    public Result add(final TEntity entity) {
        entityDao.save(entity);
        return new SuccessResult(entityMessages.entityAdded);
    }

    @Override
    public Result delete(final TEntity entity) {
        entityDao.delete(entity);
        return new SuccessResult(entityMessages.entityDeleted);
    }

    @Override
    public DataResult<List<TEntity>> getAll() {
        List<TEntity> entities =  entityDao.findAll();
        return new SuccessDataResult<List<TEntity>>(entities);
    }

    @Override
    public DataResult<TEntity> getById(final TEntityId tEntityId) {
        Optional<TEntity> entity =  entityDao.findById(tEntityId);

        if (entity.isEmpty())
            return new ErrorDataResult<TEntity>(entityMessages.entityNotFound);

        return new SuccessDataResult<TEntity>(entity.get());
    }

    @Override
    public Result update(final TEntity entity) {
        entityDao.save(entity);
        return new SuccessResult(entityMessages.entityUpdated);
    }
}
