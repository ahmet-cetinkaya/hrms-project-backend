package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.WebSiteDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSiteManager extends BaseManager<WebSiteDao, WebSite, Short> implements WebSiteService {
    private final WebSiteDao webSiteDao;

    @Autowired
    public WebSiteManager(final WebSiteDao webSiteDao) {
        super(webSiteDao, "Website");
        this.webSiteDao = webSiteDao;
    }

    @Override
    public DataResult<WebSite> getByName(final String name) {
        final Optional<WebSite> webSite = webSiteDao.findByName(name);

        if (webSite.isEmpty())
            return new ErrorDataResult<WebSite>(Messages.webSiteNotFound);

        return new SuccessDataResult<WebSite>(webSite.get());
    }
}
