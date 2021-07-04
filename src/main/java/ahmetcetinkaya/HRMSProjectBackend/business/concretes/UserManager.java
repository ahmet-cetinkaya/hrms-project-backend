package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.UserDao;

@Service
public class UserManager extends BaseManager<UserDao, User, Integer> implements UserService {
	private final UserDao userDao;

	@Autowired
	public UserManager(final UserDao userDao) {
		super(userDao, "User");
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(final String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("User"));

		return new SuccessDataResult<>(user.get());
	}

	@Override
	public Result isNotEmailExist(final String email) {
		return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.verified("A user with the mail"));
	}
}
