package tp8;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED) 
//if we use JOINED, we should add ID, it is Foreign Key.
//if TABLE_PER_CLASS, it is copy. Person copies from Professor and Student 
public class Person {

//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private int id;
	private String name;
	private int phoneNumber;
	private String emailAddress;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
