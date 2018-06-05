package tp7test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();

		int id = 0;
		Ecole ecole = new Ecole();
		ecole.setNom("Polytech Tours");
		ecole.setNombreEleves(200);

		Ecole ecole1 = new Ecole();
		ecole1.setNom("Polytech Nante");
		ecole1.setNombreEleves(400);

		int idens = 0;
		Enseignant ens = new Enseignant();
		ens.setId(idens++);
		ens.setNom("ENS1");
		ens.setPrenom("Prenom1");
		ens.setNss("12121213");

		Enseignant ens1 = new Enseignant();
		ens1.setId(idens++);
		ens1.setNom("ENS2");
		ens1.setPrenom("Prenom2");
		ens1.setNss("3423423412");

		int idad = 0;
		Adresse adresse = new Adresse();
		adresse.setId(idad++);
		adresse.setCodePost("37200");
		adresse.setNomRue("rue1");
		adresse.setNomVille("ville1");
		adresse.setNumRue(1);

		Adresse adresse1 = new Adresse();
		adresse1.setId(idad++);
		adresse1.setCodePost("37100");
		adresse1.setNomRue("rue2");
		adresse1.setNomVille("ville2");
		adresse1.setNumRue(2);

		em.getTransaction().begin();
		em.persist(ecole);
		em.persist(ecole1);
		em.persist(ens);
		em.persist(ens1);
		em.persist(adresse);
		em.persist(adresse1);
		em.getTransaction().commit();

		ens.setAdresse(adresse);
		ens1.setAdresse(adresse1);
		ens.setEcole(ecole);
		ens1.setEcole(ecole);
		ecole.getEnseignants().add(ens);
		ecole.getEnseignants().add(ens1);

		em.getTransaction().begin();
		em.persist(ecole);
		em.persist(ens);
		em.persist(ens1);

		em.getTransaction().commit();

		String input = "Polytech Tours";
		Ecole eco = em.find(Ecole.class, input);
		for (Enseignant enss : eco.getEnseignants()) {
			System.out.println(enss.getPrenom());
		}

	}
}
