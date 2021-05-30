package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.EmailValidationService;
import kodlamaio.hrms.core.UserCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {

	@Autowired
	private JobSeekerDao jobSeekerDao;
//	@Autowired
	private UserCheckService userCheckService;
	private EmailValidationService emailValidationService;

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

	@Override
	public void register(JobSeeker jobSeeker) {
//		tüm alanları girmesi zorunlu hale getirilecek: ad soyad tc doğum smail şifre şifretekrarı
		if (!this.checkFields(jobSeeker)) {
			System.out.println("eksik alan");
		} else if (!this.checkNationalityId(jobSeeker)) {
			System.out.println("hatalı tc");
		} else if (this.checkIfExists(jobSeeker)) {
			System.out.println("kayıtlı kullanıcı");
		} else if (!this.checkEmailAdress(jobSeeker)) {
			System.out.println("Geçersiz mail adresi.");
		} else {
			this.jobSeekerDao.save(jobSeeker);
			System.out.println("Her şey yolunda > " + jobSeeker.getFirstName());
		}

	}

	public boolean checkFields(JobSeeker jobSeeker) {
		if (jobSeeker.getFirstName() == null || jobSeeker.getLastName() == null || jobSeeker.getNationalityId() == null
				|| jobSeeker.getBirthYear() == 0 || jobSeeker.getPassword() == null || jobSeeker.getEmail() == null) {
			return false;
		} else
			return true;

	}

	public boolean checkNationalityId(JobSeeker jobSeeker) {
		return this.userCheckService.checkIfRealPerson(jobSeeker.getNationalityId());
//		return true;
	}

	public boolean checkIfExists(JobSeeker jobSeeker) {
		if (this.jobSeekerDao.getByEmail(jobSeeker.getEmail()) == null) {
			return false;
		} else if (this.jobSeekerDao.getByNationalityId(jobSeeker.getNationalityId()) == null) {
			return false;
		} else
			return true;
	}
	
	public boolean checkEmailAdress(JobSeeker jobSeeker) {
		if (this.emailValidationService.isValidEmail(jobSeeker.getEmail())) {
			return true;
		} else
			return false;
	}

}
