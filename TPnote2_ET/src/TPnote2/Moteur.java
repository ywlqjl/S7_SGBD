package TPnote2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="moteur")
public class Moteur extends Bateau {
	
	private int nbChevauxVapeur;

	public int getNbChevauxVapeur() {
		return nbChevauxVapeur;
	}

	public void setNbChevauxVapeur(int nbChevauxVapeur) {
		this.nbChevauxVapeur = nbChevauxVapeur;
	}
}
