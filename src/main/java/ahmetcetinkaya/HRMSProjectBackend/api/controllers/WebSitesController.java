package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/websites")
public class WebSitesController {
    private final WebSiteService webSiteService;

    @Autowired
    public WebSitesController(final WebSiteService webSiteService) {
        this.webSiteService = webSiteService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid final WebSite webSite) {
        final Result result = webSiteService.add(webSite);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody final WebSite webSite) {
        final Result result = webSiteService.delete(webSite);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<WebSite>>> getAll() {
        final DataResult<List<WebSite>> result = webSiteService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/byname")
    public ResponseEntity<DataResult<WebSite>> getByName(final String name) {
        final DataResult<WebSite> result = webSiteService.getByName(name);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody @Valid final WebSite webSite) {
        final Result result = webSiteService.update(webSite);

        return ResponseEntity.ok(result);
    }
}
