package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.LanguageService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.LanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Language;

@Service
public class LanguageManager extends BaseManager<LanguageDao, Language, String> implements LanguageService {
	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		super(languageDao, "Language");
	}
}
