package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	List<JobAdvert> getByStatusTrue();
	List<JobAdvert> getByStatusTrueAndDateOfPublish(LocalDate dateOfPublish);
	List<JobAdvert> getByStatusTrueAndEmployer(Employer employer);
	JobAdvert getById(int id);
	
}
