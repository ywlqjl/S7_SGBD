package tp8_test;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) throws SQLException
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
	
		
		Student s1 = new Student();
		s1.setName("A");
		s1.setPhoneNumber(111);
		s1.setEmailAddress("a@gmail.com");
		s1.setAverageMark(8.5);
		
		Student s2 = new Student();
		s2.setName("B");
		s2.setPhoneNumber(222);
		s2.setEmailAddress("b@gmail.com");
		s2.setAverageMark(9);
		
		Professor pr1 = new Professor();
		pr1.setName("Pascal");
		pr1.setPhoneNumber(210);
		pr1.setEmailAddress("pr1@etu.com");
		pr1.setSalary(4732.2);
		
		Professor pr2 = new Professor();
		pr2.setName("Audrer");
		pr2.setPhoneNumber(211);
		pr2.setEmailAddress("pr2@etu.com");
		pr2.setSalary(6732.2);
		
		Address ad1 = new Address();
		ad1.setCity("Tours");
		ad1.setCountry("France");
		ad1.setPostalCode("37000");
		ad1.setStreet("national");
		
		Address ad2 = new Address();
		ad2.setCity("Paris");
		ad2.setCountry("France");
		ad2.setPostalCode("37200");
		ad2.setStreet("Grammont");
		
		s1.setAddress(ad1);
		s2.setAddress(ad2);
		pr1.setAddress(ad1);
		pr2.setAddress(ad2);

		
		em.getTransaction().begin();
		em.persist(ad1);
		em.persist(ad2);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(pr1);
//		em.persist(pr2);
		
		
		em.getTransaction().commit();

	
		em.close();
		emf.close();
	}
	
	
}
