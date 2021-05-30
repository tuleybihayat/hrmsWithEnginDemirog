package kodlamaio.hrms.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailValidationManager implements EmailValidationService {

	private static final String eMailPattern = "^(.+)@(\\S+)$";
	private static final Pattern pattern = Pattern.compile(eMailPattern);


	public boolean isValidEmail(String eMail) {

//		Matcher matcher = pattern.matcher(eMail);
//		return matcher.matches();
		return true;

//		mailin daha önce kullanılıp kullanılmadığını kontrol et
	}
	
}
