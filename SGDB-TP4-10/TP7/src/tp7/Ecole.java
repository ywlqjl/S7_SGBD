package tp7;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ecole")
public class Ecole 
{
	@Id
	private String nom;
	private int nbEleves;
	
	//LAZY on cherche ce qu'on a besoin, Ecade chercher tout
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ecole") 
	private List<Enseignant> listeEnseignant = new ArrayList<Enseignant>();
	
	public void addEnseignant(Enseignant e){
		listeEnseignant.add(e);
	}
	
	//pour ajouter des fonctions desous: choisir une classe, clic a droit->source-> Generate Getters and Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbEleves() {
		return nbEleves;
	}
	
	public void setNbEleves(int nbEleves) {
		this.nbEleves = nbEleves;
	}

	public List<Enseignant> getListeEnseignant() {
		return listeEnseignant;
	}

	public void setListeEnseignant(List<Enseignant> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}


}
