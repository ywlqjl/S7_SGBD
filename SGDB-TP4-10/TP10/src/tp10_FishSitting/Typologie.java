package tp10_FishSitting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typologie")
public class Typologie {
	@Id
	private String nomTypologie;
	private String typeFond;
	private double litreEau;
	
	@ManyToMany 
	private List<Groupe> groupe = new ArrayList<Groupe>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "typologie")
	private List<Espece> espece = new ArrayList<Espece>();

	public String getNomTypologie() {
		return nomTypologie;
	}

	public void setNomTypologie(String nomTypologie) {
		this.nomTypologie = nomTypologie;
	}

	public String getTypeFond() {
		return typeFond;
	}

	public void setTypeFond(String typeFond) {
		this.typeFond = typeFond;
	}

	public double getLitreEau() {
		return litreEau;
	}

	public void setLitreEau(double litreEau) {
		this.litreEau = litreEau;
	}

	public List<Groupe> getGroupe() {
		return groupe;
	}

	public void setGroupe(List<Groupe> groupe) {
		this.groupe = groupe;
	}
}
