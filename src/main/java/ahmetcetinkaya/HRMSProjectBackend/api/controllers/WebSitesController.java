package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;

@RestController
@RequestMapping("/api/websites")
public class WebSitesController extends BaseController<WebSiteService, WebSite, Short> {
	@Autowired
	public WebSitesController(final WebSiteService webSiteService) {
		super(webSiteService);
	}
}
