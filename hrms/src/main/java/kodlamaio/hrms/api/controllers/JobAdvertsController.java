package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/jobadverts")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertsController {
	
	@Autowired
	private JobAdvertService jobAdvertService;
	
	@PostMapping("/add")
	public void add(@RequestBody JobAdvert jobAdvert) {
		this.jobAdvertService.add(jobAdvert);
	}
	@GetMapping("/getall")
	public List<JobAdvert> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getbystatustrue")
	public List<JobAdvert> getByStatusTrue(){
		return this.jobAdvertService.getByStatusTrue();
	}
	
	@GetMapping("/getbystatustrueanddateofpublish")
	public List<JobAdvert> getByStatusTrueAndDateOfPublish(@RequestParam LocalDate dateOfPublish){
		return this.jobAdvertService.getByStatusTrueAndDateOfPublish(dateOfPublish);
	}
	
	@GetMapping("/getByStatusTrueAndEmployer")
	public List<JobAdvert> getByStatusTrueAndEmployer(@RequestParam Employer employer){
		return this.jobAdvertService.getByStatusTrueAndEmployer(employer);
	}
	
	@PostMapping("/closejobadvert")
	public void closeJobAdvert(int id) {
		this.jobAdvertService.closeJobAdvert(id);
	}
}
