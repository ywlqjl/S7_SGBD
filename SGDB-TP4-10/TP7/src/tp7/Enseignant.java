package tp7;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="enseignant")
public class Enseignant
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String NSS;
	private String prenom;
	private String nom;


	@ManyToOne 
	private Ecole ecole; 
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	//(cascade = CascadeType)// quand on ajoute Enseignant on a besoin de que persist Enseignant, adresse auto-ajout
	private Adresse adresse;
	
/*	public Enseignant(String lastname, String firstname, String NSS, Adresse adresse)
	{
		this.prenom = lastname;
		this.nom = firstname;
		this.NSS = NSS; 
		this.adresse = adresse;
		
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastname() {
		return prenom;
	}

	public void setLastname(String lastname) {
		this.prenom = lastname;
	}

	public String getFirstname() {
		return nom;
	}

	public void setFirstname(String firstname) {
		this.nom = firstname;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	
}