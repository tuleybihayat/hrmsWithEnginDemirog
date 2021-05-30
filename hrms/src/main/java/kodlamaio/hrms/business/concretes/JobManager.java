package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class JobManager implements JobService {

	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<Job> getAll() {
		return this.jobDao.findAll();
	}

	@Override
	public void addJob(Job job) {
		if (this.jobDao.getByTitle(job.getTitle()) != null) {
			System.out.println("kayıtlı meslek dalı");
		} else 
			this.jobDao.save(job);		
	}
}
