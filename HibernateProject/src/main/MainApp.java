package main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainApp
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		Enseignant e = new Enseignant("Maxime", "Alvarez", "19/11/1996", new Adresse());
		
		em.getTransaction().begin();
		em.persist(e);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
