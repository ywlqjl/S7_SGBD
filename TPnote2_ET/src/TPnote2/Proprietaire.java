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
@Table(name="proprietaire")
public class Proprietaire {

	@Id
	private String nomProprietaire;
	private String adresseP;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "proprietaire") 
	private List<Bateau> listeBateau = new ArrayList<Bateau>();

	
	
	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getAdresseP() {
		return adresseP;
	}

	public void setAdresseP(String adresseP) {
		this.adresseP = adresseP;
	}

	public List<Bateau> getListeBateau() {
		return listeBateau;
	}

	public void setListeBateau(List<Bateau> listeBateau) {
		this.listeBateau = listeBateau;
	}
}
