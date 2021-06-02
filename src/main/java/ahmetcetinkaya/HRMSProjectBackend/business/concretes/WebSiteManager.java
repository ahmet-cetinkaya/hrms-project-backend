package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.WebSiteDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;

@Service
public class WebSiteManager implements WebSiteService {
	private WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(final WebSiteDao webSiteDao) {
		this.webSiteDao = webSiteDao;
	}

	@Override
	public Result add(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.WebSiteAdded);
	}

	@Override
	public Result delete(final WebSite webSite) {
		webSiteDao.delete(webSite);

		return new SuccessResult(Messages.WebSiteDeleted);
	}

	@Override
	public DataResult<List<WebSite>> getAll() {
		final List<WebSite> webSites = webSiteDao.findAll();

		return new SuccessDataResult<List<WebSite>>(webSites);
	}

	@Override
	public DataResult<WebSite> getById(final Short id) {
		final Optional<WebSite> webSite = webSiteDao.findById(id);

		if (webSite.isEmpty())
			return new ErrorDataResult<WebSite>(Messages.WebSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public DataResult<WebSite> getByName(final String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isEmpty())
			return new ErrorDataResult<WebSite>(Messages.WebSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public Result update(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.WebSiteUpdated);
	}
}
