package tp10_FishSitting;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="vasque")
public class Vasque {
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idV;
	private String materiel;
	private double capaciteL;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "vasque")	
	private Groupe groupe;


	public int getIdV() {
		return idV;
	}


	public void setIdV(int idV) {
		this.idV = idV;
	}


	public String getMateriel() {
		return materiel;
	}


	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}


	public double getCapaciteL() {
		return capaciteL;
	}


	public void setCapaciteL(double capaciteL) {
		this.capaciteL = capaciteL;
	}


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
}
