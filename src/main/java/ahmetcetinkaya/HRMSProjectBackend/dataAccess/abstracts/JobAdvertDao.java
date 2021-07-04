package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	Page<JobAdvert> findAllByIsActive(boolean isActive, Pageable pageable);

	@Query("SELECT new ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto(j.id,e.companyName,c.name,p.title,j.numberOfOpenPositions,wt.name,j.createdAt,j.applicationDeadline,j.minSalary,j.maxSalary) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p JOIN j.city c JOIN j.workingTime wt WHERE j.isActive=:isActive AND e.companyName=:companyName")
	Page<JobAdvertForListDto> findAllByIsActiveAndEmployer_CompanyNameForList(@Param("isActive") boolean isActive,
			@Param("companyName") String companyName, Pageable pageable);

	@Query("SELECT new ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto(j.id,e.companyName,c.name,p.title,j.numberOfOpenPositions,wt.name,j.createdAt,j.applicationDeadline,j.minSalary,j.maxSalary) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p JOIN j.city c JOIN j.workingTime wt WHERE j.isActive=:isActive")
	Page<JobAdvertForListDto> findAllByIsActiveForList(@Param("isActive") boolean isActive, Pageable pageable);

	@Query("SELECT new ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto(j.id,e.companyName,c.name,p.title,j.numberOfOpenPositions,wt.name,j.createdAt,j.applicationDeadline,j.minSalary,j.maxSalary) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p JOIN j.city c JOIN j.workingTime wt WHERE j.isActive=:isActive AND c.id=:cityId AND wt.id=:workingTimeId")
	Page<JobAdvertForListDto> findAllByIsActiveAndCityAndWorkingTimeForList(@Param("isActive") boolean isActive,
			@Param("cityId") short cityId, @Param("workingTimeId") short workingTimeId, Pageable pageable);
}