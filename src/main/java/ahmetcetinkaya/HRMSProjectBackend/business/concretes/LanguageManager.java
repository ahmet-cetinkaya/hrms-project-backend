package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.LanguageService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.LanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.LanguageAdded);
	}

	@Override
	public Result delete(final Language language) {
		languageDao.delete(language);

		return new SuccessResult(Messages.LanguageDeleted);
	}

	@Override
	public DataResult<List<Language>> getAll() {
		final List<Language> language = languageDao.findAll();

		return new SuccessDataResult<List<Language>>(language);
	}

	@Override
	public DataResult<Language> getById(final String id) {
		final Optional<Language> language = languageDao.findById(id);

		if (language.isEmpty())
			return new ErrorDataResult<Language>(Messages.LanguageNotFound);

		return new SuccessDataResult<Language>(language.get());
	}

	@Override
	public Result update(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.LanguageUpdated);
	}

}