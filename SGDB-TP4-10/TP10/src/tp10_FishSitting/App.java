package tp10_FishSitting;


import java.util.List;
import javax.persistence.*;

public class App {
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
	
		Espece e1 = new Espece();
		e1.setNomEspece("PetitRouge");
		Espece e2 = new Espece();
		e2.setNomEspece("PetitJaune");
		Espece e3 = new Espece();
		e3.setNomEspece("PetitVert");
		Espece e4 = new Espece();
		e4.setNomEspece("XiaoChouYu");
		Espece e5 = new Espece();
		e5.setNomEspece("Ningmeng");
		Espece e6 = new Espece();
		e6.setNomEspece("Hudie");
		
		Vasque v1 = new Vasque();
		v1.setCapaciteL(50);
		v1.setIdV(0);
		v1.setMateriel("wood");
		
		Vasque v2 = new Vasque();
		v2.setCapaciteL(60);
		v2.setIdV(1);
		v2.setMateriel("plastique");
		
		Typologie t1 = new Typologie();
		t1.setLitreEau(12.2);
		t1.setNomTypologie("TA");
		t1.setTypeFond("sablonneux");

		Typologie t2 = new Typologie();
		t2.setLitreEau(17.2);
		t2.setNomTypologie("TB");
		t2.setTypeFond("graveleux");
		
		Groupe g1 = new Groupe();
		g1.setAdresseP("aaaaa");
		g1.setNomProprietaire("Anna");
		g1.setNumTel("0769499079");
		g1.setNbRepasParJour(3);
		g1.setVasque(v1);
		g1.addTypologie(t1);
		g1.addTypologie(t2);
		
		Groupe g2 = new Groupe();
		g2.setAdresseP("bbbbb");
		g2.setNomProprietaire("British");
		g2.setNumTel("0768585868");
		g2.setNbRepasParJour(3);
		g2.setVasque(v2);
		g2.addTypologie(t1);

		e1.setTypologie(t1);
		e2.setTypologie(t1);
		e3.setTypologie(t1);
		e4.setTypologie(t2);
		e5.setTypologie(t2);
		e6.setTypologie(t2);
		
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		em.persist(e6);
		
		em.persist(v1);
		em.persist(v2);
		em.persist(t1);
		em.persist(t2);
		em.persist(g1);
		em.persist(g2);
		
		em.getTransaction().commit();

		
		
//		String queryString = "select student.name, from student s "; 
//		Query query = em.createQuery(queryString);
//		
//		List results = query.getResultList();
//		for (int i = 0; i < results.size(); i++) {
//		    System.out.println(results.get(i));
//		}
//	
		em.close();
		emf.close();
	}
	
	
}
