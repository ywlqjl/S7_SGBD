package tp7test;

import javax.persistence.*;

@Entity
public class Enseignant {
	
	@Id
	private int id;
	private String nss;
	private String nom;
	private String prenom;
	
	@OneToOne
	//@JoinColumn(name = "domicile",unique = true)
	private Adresse adresse;
	
	@ManyToOne
	private Ecole ecole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
}
