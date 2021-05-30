package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/jobseekers")
@AllArgsConstructor
@NoArgsConstructor

public class JobSeekersController {

	@Autowired
	private JobSeekerService jobSeekerService;
	
	@GetMapping("/getall")
	public List<JobSeeker> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/register")
	public  void register(@RequestBody JobSeeker jobSeeker) {
		this.jobSeekerService.register(jobSeeker);
	}
	
	
}
