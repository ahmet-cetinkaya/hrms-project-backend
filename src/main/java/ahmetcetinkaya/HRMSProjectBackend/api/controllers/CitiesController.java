package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CityService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private final CityService cityService;

    @Autowired
    public CitiesController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<City>>> getAll() {
        final DataResult<List<City>> result = cityService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<City>> getById(final short id) {
        final DataResult<City> result = cityService.getById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbyname")
    public ResponseEntity<DataResult<City>> getByName(final String name) {
        final DataResult<City> result = cityService.getByName(name);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbynamecontains")
    public ResponseEntity<DataResult<List<City>>> getByNameContains(final String name) {
        final DataResult<List<City>> result = cityService.getByNameContains(name);

        return ResponseEntity.ok(result);
    }
}
