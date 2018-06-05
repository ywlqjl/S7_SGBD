package tp9;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job {

	@Id
	private String title;
	private String employeeId;
	private float salary;
	
	@ManyToOne()
	private Company company;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Person person;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
//	public String getIdJob() {
//		return idJob;
//	}
//	public void setIdJob(String idJob) {
//		this.idJob = idJob;
//	}
	
	
	
}
