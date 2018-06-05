package tp8;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="professor")

public class Professor extends Person {

	@Id
	private int idP;
//	@Column(name="aaaa") 
	@Column(name="gongzi")
	private double salary;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	@JoinColumn(name="dizhi") 
	private Address address;
	
	public Professor(){
		
	}
	
	
	public int getIdP() {
		return idP;
	}
	
	public void setIdP(int idP) {
		this.idP = idP;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	


	
}
