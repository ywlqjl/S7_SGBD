package main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ecole")
public class Ecole 
{
	@Id
	@Column(name = "Nom", unique = true)
	@GeneratedValue
	private String nom;
	
	
	private Integer nbEleves;
	
	@OneToMany(mappedBy = "ecole") 
	private List<Enseignant> listeEnseignant;

	/**
	 * @return the nbEleves
	 */
	public Integer getNbEleves() {
		return nbEleves;
	}

	/**
	 * @param nbEleves the nbEleves to set
	 */
	public void setNbEleves(Integer nbEleves) {
		this.nbEleves = nbEleves;
	}

	/**
	 * @return the listeEnseignant
	 */
	public List<Enseignant> getListeEnseignant() {
		return listeEnseignant;
	}

	/**
	 * @param listeEnseignant the listeEnseignant to set
	 */
	public void setListeEnseignant(List<Enseignant> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}


}
