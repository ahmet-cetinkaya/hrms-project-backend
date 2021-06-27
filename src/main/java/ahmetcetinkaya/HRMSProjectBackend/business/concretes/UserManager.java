package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.UserDao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserManager(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(final User user) {
        userDao.save(user);

        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public Result delete(final User user) {
        userDao.delete(user);

        return new SuccessResult(Messages.userDeleted);
    }

    @Override
    public DataResult<List<User>> getAll() {
        final List<User> users = userDao.findAll();

        return new SuccessDataResult<List<User>>(users);
    }

    @Override
    public DataResult<User> getByEmail(final String email) {
        final Optional<User> user = userDao.findByEmail(email);

        if (user.isEmpty())
            return new ErrorDataResult<User>(Messages.userNotFound);

        return new SuccessDataResult<User>(user.get());
    }

    @Override
    public DataResult<User> getById(final Integer id) {
        final Optional<User> user = userDao.findById(id);

        if (user.isEmpty())
            new ErrorDataResult<User>(Messages.userNotFound);

        return new SuccessDataResult<User>(user.get());
    }

    @Override
    public Result isNotEmailExist(final String email) {
        return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
                : new ErrorResult(Messages.userWithMailAlreadyExits);
    }

    @Override
    public Result update(final User user) {
        userDao.save(user);

        return new SuccessResult(Messages.userUpdated);
    }

}
