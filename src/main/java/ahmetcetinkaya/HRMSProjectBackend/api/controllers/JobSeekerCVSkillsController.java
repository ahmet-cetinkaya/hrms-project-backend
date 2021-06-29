package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVSkillService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekers/cvs/skills")
public class JobSeekerCVSkillsController extends BaseController<JobSeekerCVSkillService, JobSeekerCVSkill, Integer> {
    private final JobSeekerCVSkillService jobSeekerCVSkillService;

    @Autowired
    public JobSeekerCVSkillsController(final JobSeekerCVSkillService jobSeekerCVSkillService) {
        super(jobSeekerCVSkillService);
        this.jobSeekerCVSkillService = jobSeekerCVSkillService;
    }

    @GetMapping("/byjobseekercvid")
    public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

        return ResponseEntity.ok(result);
    }
}
