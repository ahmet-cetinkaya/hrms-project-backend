package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.email.EmailService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.UserDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.User;

@Service
public class UserManager implements UserService {
	private final UserDao userDao;
	private final EmailService emailService;
	private final EmailActivationService emailActivationService;

	@Autowired
	public UserManager(final UserDao userDao, final EmailService emailService,
			final EmailActivationService emailActivationService) {
		this.userDao = userDao;
		this.emailService = emailService;
		this.emailActivationService = emailActivationService;
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
		final User user = userDao.findByEmail(email);

		if (user == null)
			return new ErrorDataResult<User>(Messages.userNotFound);

		return new SuccessDataResult<User>(user);
	}

	@Override
	public DataResult<User> getById(final int id) {
		final User user = userDao.findById(id).get();

		return new SuccessDataResult<User>(user);
	}

	private Result isNotEmailExist(final String email) {
		return userDao.findByEmail(email) == null ? new SuccessResult()
				: new ErrorResult(Messages.userWithMailAlreadyExits);
	}

	@Override
	public Result register(final User user) {
		final Result businessRulesResult = BusinessRules.run(isNotEmailExist(user.getEmail()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		// TODO Password Hash
		add(user);
		emailActivationService.createAndSendByMail(user.getId(), user.getEmail());

		return new SuccessResult(Messages.userRegistered);
	}

	@Override
	public Result update(final User user) {
		userDao.save(user);

		return new SuccessResult(Messages.userUpdated);
	}

}
