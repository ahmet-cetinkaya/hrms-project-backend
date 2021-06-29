package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.LanguageService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.LanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Language;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager extends BaseManager<LanguageDao, Language, String> implements LanguageService {
    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(final LanguageDao languageDao) {
        super(languageDao, "Language");
        this.languageDao = languageDao;
    }

    @Override
    public Result add(final Language language) {
        languageDao.save(language);

        return new SuccessResult(Messages.languageAdded);
    }

    @Override
    public Result delete(final Language language) {
        languageDao.delete(language);

        return new SuccessResult(Messages.languageDeleted);
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
            return new ErrorDataResult<Language>(Messages.languageNotFound);

        return new SuccessDataResult<Language>(language.get());
    }

    @Override
    public Result update(final Language language) {
        languageDao.save(language);

        return new SuccessResult(Messages.languageUpdated);
    }

}
