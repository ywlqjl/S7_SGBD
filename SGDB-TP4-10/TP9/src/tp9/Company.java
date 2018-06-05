package tp9;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company extends Address {

	@Id
//	private String IdCompany;
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy ="company")
	private List<Job> listJob = new ArrayList<Job>();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


//	public String getIdCompany() {
//		return IdCompany;
//	}
//
//	public void setIdCompany(String idCompany) {
//		IdCompany = idCompany;
//	}

	public List<Job> getListJob() {
		return listJob;
	}

	public void setListJob(List<Job> listJob) {
		this.listJob = listJob;
	}

	
}


