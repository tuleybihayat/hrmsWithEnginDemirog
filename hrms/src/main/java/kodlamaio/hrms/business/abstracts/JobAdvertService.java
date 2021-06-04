package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	void add(JobAdvert jobAdvert);
	List<JobAdvert> getAll();
	List<JobAdvert> getByStatusTrue();
	List<JobAdvert> getByStatusTrueAndDateOfPublish(LocalDate dateOfPublish);
	List<JobAdvert> getByStatusTrueAndEmployer(Employer employer);
	void closeJobAdvert(int id);
	
}
