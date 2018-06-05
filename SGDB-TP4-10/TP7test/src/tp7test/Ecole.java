package tp7test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ecole {

	@Id
	private String nom;
	private int nombreEleves;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ecole")
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();;

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreEleves() {
		return nombreEleves;
	}

	public void setNombreEleves(int nombreEleves) {
		this.nombreEleves = nombreEleves;
	}

}
