package TPnote2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="quai")
public class Quai {

	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int codeQ;
	private int nbEmplacement;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "quai") 
	private List<Emplacement> listeEmplacement = new ArrayList<Emplacement>();

	
	
	public int getCodeQ() {
		return codeQ;
	}

	public void setCodeQ(int codeQ) {
		this.codeQ = codeQ;
	}

	public int getNbEmplacement() {
		return nbEmplacement;
	}

	public void setNbEmplacement(int nbEmplacement) {
		this.nbEmplacement = nbEmplacement;
	}

	public List<Emplacement> getListeEmplacement() {
		return listeEmplacement;
	}

	public void setListeEmplacement(List<Emplacement> listeEmplacement) {
		this.listeEmplacement = listeEmplacement;
	}
	
}

