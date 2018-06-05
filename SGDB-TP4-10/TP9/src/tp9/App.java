package tp9;

import javax.persistence.*;

public class App {
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
	
		
		Person p1 = new Person();
		p1.setCity("Tours");
		p1.setFirstName("wenli");
		p1.setLastName("YAN");
		p1.setPostalCode("37200");
		
		Person p2 = new Person();
		p2.setCity("Paris");
		p2.setFirstName("Person2");
		p2.setLastName("B");
		p2.setPostalCode("90090");
		
		
		Company c1 = new Company();
//		c1.setIdCompany("C01");
		c1.setName("Company1");
		
		Job j1 = new Job();
		j1.setTitle("Ingenieur");
//		j1.setIdJob("J01");
		j1.setPerson(p1);
		j1.setCompany(c1);
		
		Job j2 = new Job();
		j2.setTitle("Manager");
//		j2.setIdJob("J02");
		j2.setPerson(p2);
		j2.setCompany(c1);
	
	

		

		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(c1);
		em.persist(j2);
		em.persist(j1);


		em.getTransaction().commit();
		
	/*
		
		Ecole e = em.find(Ecole.class, "Polytech Tours");
		System.out.println(e.getNbEleves());
		System.out.println(e.getListeEnseignant().get(0).getNSS());//on cherche que les choses qu'on a besoin
		
		em.getTransaction().begin();
		Enseignant en = em.find(Enseignant.class, 1);
		en.getAdresse().setNomRue("Leclerc");
		em.getTransaction().commit();
	*/	
		
		em.close();
		emf.close();
	}
	
	
}
