package kodlamaio.hrms.core;

public interface EmailVerificationService {

	void sendEmailToVerify(String email);
	void verifyEmail(String email);
}
