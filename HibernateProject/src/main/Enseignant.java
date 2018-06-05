package main;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="enseignant")
public class Enseignant
{
	@Id
	@GeneratedValue
	private String NSS;
	private String prenom;
	private String nom;


	@ManyToOne 
	private Ecole ecole; 
	
	@OneToOne(mappedBy = "enseignant") // foreign key
	private Adresse adresse;
	
	public Enseignant(String lastname, String firstname, String NSS, Adresse adresse)
	{
		this.prenom = lastname;
		this.nom = firstname;
		this.NSS = NSS; 
		this.adresse = adresse;
		
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return prenom;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.prenom = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return nom;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.nom = firstname;
	}

	/**
	 * @return the nSS
	 */
	public String getNSS() {
		return NSS;
	}

	/**
	 * @param nSS the nSS to set
	 */
	public void setNSS(String nSS) {
		NSS = nSS;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}