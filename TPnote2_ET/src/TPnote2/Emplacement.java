package TPnote2;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="emplacement")
public class Emplacement {
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int codeE;
	private double tailleE;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "emplacement")
	private Bateau bateau;
	
	@ManyToOne 
	private Quai quai;
	
	
	
	public int getCodeE() {
		return codeE;
	}

	public void setCodeE(int codeE) {
		this.codeE = codeE;
	}


	public double getTailleE() {
		return tailleE;
	}

	public void setTailleE(double tailleE) {
		this.tailleE = tailleE;
	}

	public Quai getQuai() {
		return quai;
	}

	public void setQuai(Quai quai) {
		this.quai = quai;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}



}
