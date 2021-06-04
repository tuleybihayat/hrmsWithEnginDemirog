package kodlamaio.hrms.core;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public void sendEmailToVerify(String email) {
		System.out.println("Doğrulama için mail gönderildi.");
		
	}

	@Override
	public void verifyEmail(String email) {
		System.out.println("Email doğrulandı.");
		
	}

}
