package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_adverts")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Job job;
	
	@Column(name = "advert_title")
	private String advertTitle;
	
	@Column(name = "advert_body")
	private String advertBody;
	
	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
	private City city;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "last_date_to_apply")
	private LocalDate lastDateToApply;
	
	@Column(name = "date_of_publish")
	private LocalDate dateOfPublish;
	
	@Column(name = "status")
	private boolean status;

}
