package tp10_FishSitting;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="espece")
public class Espece {

	@Id
	private String nomEspece;

	@ManyToOne
	private Typologie typologie = new Typologie();
	
	
	public String getNomEspece() {
		return nomEspece;
	}

	public void setNomEspece(String nomEspece) {
		this.nomEspece = nomEspece;
	}

	public Typologie getTypologie() {
		return typologie;
	}

	public void setTypologie(Typologie typologie) {
		this.typologie = typologie;
	}
}
