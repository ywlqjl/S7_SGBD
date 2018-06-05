package tp8_test;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends Person{

	//@Id
	private int studentNumber;
	private double averageMark;

	
	
	public Student(){
		
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public double getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}


}
