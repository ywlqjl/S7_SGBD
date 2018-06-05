package tp8_test;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	private String street;
	private String state;
	private String postalCode;
	private String city;
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
	private Person person;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Professor professor;
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Student student;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
//	public Person getPerson() {
//		return person;
//	}
//	public void setPerson(Person person) {
//		this.person = person;
//	}
	
}
