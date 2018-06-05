package tp8;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProfessorDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
	EntityManager em = emf.createEntityManager();
	
	
	
	public void getResult() throws SQLException {
		try{
			//just 1 ligne
//			String queryString = "select p.name from Professor p"; //ici il faut ecrire le nom de Class.java
//			Query query = em.createQuery(queryString);
//			
//			List results = query.getResultList();
//			for (int i = 0; i < results.size(); i++) {
//			    System.out.println(results.get(i));
//			}
			

			Scanner s = new Scanner(System.in);
			String nom = s.nextLine();
			
			// 2 lignes
			String queryString = "select p.name, p.salary from Professor p where p.name = ?1"; //ici il faut ecrire le nom de Class.java
			Query query = em.createQuery(queryString);
			query.setParameter(1, nom);
			
			List results = query.getResultList();
			for (int i = 0; i < results.size(); i++) {
				Object[] firstResult = (Object[])results.get(i);
				String s1 = (String)firstResult[0];
				double s2 = (double)firstResult[1];
			    System.out.println(s1+"\t"+s2);
			}
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	
	
	public void sql2(){
		
		String queryString = "select p.name from Professor p join Address a on p.address  = a.street where a.country = 'France' "; 
		//ici il faut ecrire le nom de Class.java apres 'From'
		Query query = em.createQuery(queryString);
		
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
		    System.out.println(results.get(i));
		}

	}
	


}
