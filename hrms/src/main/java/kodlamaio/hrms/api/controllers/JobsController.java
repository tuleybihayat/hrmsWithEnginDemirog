package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.entities.concretes.Job;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/jobs")
@AllArgsConstructor


public class JobsController {

	@Autowired
	private JobService jobService;
	
	@GetMapping("/getall")
	public List<Job> getAll() {
		return this.jobService.getAll();
	}

	@PostMapping("/addjob")
	public void addJob(@RequestBody Job job) {
		this.jobService.addJob(job);
	}
	
//	@PostMapping("/addjob")
//	public void addJob(Job job) {
//		this.jobService.addJob(job);
//	}


	

}
