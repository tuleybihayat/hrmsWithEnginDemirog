package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")

public class Employer extends User {

//	@OneToOne
//	@JoinColumn(name = "employer_id", referencedColumnName = "id")
//	@PrimaryKeyJoinColumn(name = "id")
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_site")
	private String webSite;

	@Column(name = "phone_number") 
	private String phoneNumber;

	public Employer(String email, String password, String companyName, String webSite, String phoneNumber) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		
	}
	

}
