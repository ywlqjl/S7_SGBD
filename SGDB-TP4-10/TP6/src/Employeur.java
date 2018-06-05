import java.sql.Date;
import java.util.Scanner;

import javax.persistence.*;

@Entity
public class Employeur {
	
	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	private String nom;
	private String prenom;
	private String dateNaissance;
	private Double salaire;
	
	//Constructeur
	public Employeur(int id, String nom, String prenom, String dateNaissance, Double salaire) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.salaire = salaire;
	}

	//getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	
	
	
	//public void ajouterEmployeur(long id, String nom, String prenom, String dateNaissance, Double salaire){
/*	public void ajouterEmployeur(){
		Scanner reader =  new Scanner(System.in);
		System.out.println("Entrez un numero d'ID :");
		long idE = reader.nextLong();
		
		reader =  new Scanner(System.in);
		System.out.println("Entrez un nom :");
		String nomE = reader.next();
		
		reader =  new Scanner(System.in);
		System.out.println("Entrez un prenom :");
		String prenomE = reader.next();
		
		reader =  new Scanner(System.in);
		System.out.println("Entrez un dateNaissance :");
		String dateNaissanceE = reader.next();
		
		reader =  new Scanner(System.in);
		System.out.println("Entrez une salaire :");
		Double salaireE = reader.nextDouble();
		
		new Employeur(idE, nomE, prenomE,dateNaissanceE,salaireE);
		
		
	}*/


	
}
