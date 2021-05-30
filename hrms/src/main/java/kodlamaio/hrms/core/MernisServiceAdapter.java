package kodlamaio.hrms.core;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService {

	public boolean checkIfRealPerson(String nationalityId) {
		return true;
	}
}
