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
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User {
	
//	@OneToOne
//	@JoinColumn(name = "job_seeker_id", referencedColumnName = "id")
//	private User user;
//	@PrimaryKeyJoinColumn(name = "id")
//	private User user;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_id")
	private String nationalityId;

	@Column(name = "birth_year")
	private int birthYear;

	public JobSeeker(String email, String password, String firstName,
			String lastName, String nationalityId, int birthYear) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}

	
}
