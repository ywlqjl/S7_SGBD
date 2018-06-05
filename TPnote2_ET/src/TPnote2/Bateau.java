package TPnote2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="bateau")
public class Bateau {
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idBateau;
	private String nomBateau;
	private double poids;

	@ManyToOne 
	private Proprietaire proprietaire;
	
	@OneToOne(fetch = FetchType.LAZY)// pas: mappedBy = "bateau"
	private Emplacement emplacement;

	
	
	
	public String getNomBateau() {
		return nomBateau;
	}

	public void setNomBateau(String nomBateau) {
		this.nomBateau = nomBateau;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getIdBateau() {
		return idBateau;
	}

	public void setIdBateau(int idBateau) {
		this.idBateau = idBateau;
	}

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	} 
	



}
