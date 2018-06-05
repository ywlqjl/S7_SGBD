import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Application {
	
	
	
	public static void main(String[] args) {
		
		// 1 : Ouverture unite de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet metier
		Employeur emp = new Employeur(0, "Neron", "Emmanuel","30/08/1992",100000.9);
		Employeur a = new Employeur(1, "Nahb", "Emmanuh","30/09/1992",210001.9);
		
		//emp.ajouterEmployeur();
		 
		// 4 : Persistance Objet/Relationnel : creation d'un enregistrement en base
		 em.persist(emp); em.persist(a);
		
		// 5 : Fermeture transaction 
		 tx.commit();
		
		// 6 : Fermeture unite de travail JPA 
		em.close();
		emf.close();	
	}

	
}
