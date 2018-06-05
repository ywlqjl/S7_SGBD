package tp8_test;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="professor")

public class Professor extends Person {

	//@Id
	private int idP;
	
	private double salary;
	

	
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


	


	
}
