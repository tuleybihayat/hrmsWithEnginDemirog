package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	@Autowired
	private JobAdvertDao jobAdvertDao;

	@Override
	public List<JobAdvert> getAll() {
		return this.jobAdvertDao.findAll();
	}

	@Override
	public List<JobAdvert> getByStatusTrue() {
		return this.jobAdvertDao.getByStatusTrue();
	}

	@Override
	public List<JobAdvert> getByStatusTrueAndDateOfPublish(LocalDate dateOfPublish) {
		return this.jobAdvertDao.getByStatusTrueAndDateOfPublish(dateOfPublish);
	}

	@Override
	public List<JobAdvert> getByStatusTrueAndEmployer(Employer employer) {
		return this.jobAdvertDao.getByStatusTrueAndEmployer(employer);
	}

	@Override
	public void closeJobAdvert(int id) {
		JobAdvert advertToClose = this.jobAdvertDao.getById(id);
		advertToClose.setStatus(false);
		this.jobAdvertDao.save(advertToClose);
	}

	@Override
	public void add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		System.out.println("kaydedildi");
		
	}

	
}
