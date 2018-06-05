package TPnote2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDAO {
	
	public EntityManagerFactory emf;
	public EntityManager em;
	
	public void connection(){
		
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();

	}
	
	public void Tbegin(EntityManager em){
		em.getTransaction().begin();
	
	}
	public void Tcommit(EntityManager em){
		em.getTransaction().commit();
	
	}
	
	public void Tclose(EntityManager em, EntityManagerFactory emf){
		em.close();
		emf.close();
	
	}

	
	
}
