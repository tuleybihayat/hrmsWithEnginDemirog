package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
@NoArgsConstructor

public class EmployersController {

	@Autowired
	private EmployerService employerService;
	
	@GetMapping("/getall")
	public List<Employer> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/register")
	public  void register(@RequestBody Employer employer) {
		this.employerService.register(employer);
	}
}
