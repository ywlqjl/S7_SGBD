package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="adresse")
public class Adresse 
{
	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue
	private Integer ID;
	
	
	private String codePostal;
	private String nomVille;
	private String nomRue;
	private Integer numRue; 
	
	@OneToOne 
	private Enseignant enseignant;

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the nomVille
	 */
	public String getNomVille() {
		return nomVille;
	}

	/**
	 * @param nomVille the nomVille to set
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	/**
	 * @return the nomRue
	 */
	public String getNomRue() {
		return nomRue;
	}

	/**
	 * @param nomRue the nomRue to set
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	/**
	 * @return the numRue
	 */
	public Integer getNumRue() {
		return numRue;
	}

	/**
	 * @param numRue the numRue to set
	 */
	public void setNumRue(Integer numRue) {
		this.numRue = numRue;
	}

	/**
	 * @return the enseignant
	 */
	public Enseignant getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant the enseignant to set
	 */
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	
	

	
}
