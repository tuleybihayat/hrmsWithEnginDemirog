package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.EmailValidationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmployerManager implements EmployerService {

	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private EmailValidationService emailValidationService;

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public void register(Employer employer) {
//		tüm alanları girmesi zorunlu hale getirilecek: ad soyad tc doğum smail şifre şifretekrarı
		if (!this.checkFields(employer)) {
			System.out.println("eksik alan");
		} else if (this.checkIfExists(employer)) {
			System.out.println("kayıtlı kullanıcı");
		} else if (!this.checkEmailAdress(employer)) {
			System.out.println("Geçersiz mail adresi.");
		} else if (!employer.getEmail().equals(employer.getWebSite())) {
			System.out.println("email ve web sitesi farklı");
//			şimdilik email ve web sitesi domainleri karşılaştırması fake olarak halledildi.
		} else {
			this.employerDao.save(employer);
			System.out.println("Her şey yolunda >> " + employer.getCompanyName());
		}

	}

	public boolean checkFields(Employer employer) {
		if (employer.getEmail() == null ||
				employer.getPassword() == null ||
				employer.getCompanyName() == null ||
				employer.getWebSite() == null ||
				employer.getPhoneNumber() == null) {
			return false;
		} else
			return true;

	}

	public boolean checkIfExists(Employer employer) {
		if (this.employerDao.getByEmail(employer.getEmail()) == null) {
			return false;
		} else
			return true;
	}
	
	public boolean checkEmailAdress(Employer employer) {
		if (this.emailValidationService.isValidEmail(employer.getEmail())) {
			return true;
		} else
			return false;
	}

}
