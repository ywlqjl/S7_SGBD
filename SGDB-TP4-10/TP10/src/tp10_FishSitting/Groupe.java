package tp10_FishSitting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="groupe")
public class Groupe {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idG;
	private String nomProprietaire;
	private String adresseP;
	private String numTel;
	private int nbRepasParJour;
	private int nbParTypo;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	private Vasque vasque;
	
	@ManyToMany (cascade = CascadeType.ALL, mappedBy = "groupe") 
	private List<Typologie> listTypologie = new ArrayList<Typologie>();
	
	public void addTypologie(Typologie e){
		listTypologie.add(e);
	}
	
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
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public int getNbRepasParJour() {
		return nbRepasParJour;
	}
	public void setNbRepasParJour(int nbRepasParJour) {
		this.nbRepasParJour = nbRepasParJour;
	}
	public int getNomParTypo() {
		return nbParTypo;
	}
	public void setNomParTypo(int nomParTypo) {
		this.nbParTypo = nomParTypo;
	}
	public Vasque getVasque() {
		return vasque;
	}
	public void setVasque(Vasque vasque) {
		this.vasque = vasque;
	}
	public List<Typologie> getTypologie() {
		return listTypologie;
	}
	public void setTypologie(List<Typologie> listTypologie) {
		this.listTypologie = listTypologie;
	}
	public int getIdG() {
		return idG;
	}
	public void setIdG(int idG) {
		this.idG = idG;
	}

	
}
