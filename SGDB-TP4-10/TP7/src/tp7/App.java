package tp7;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
	
		Ecole ecole = new Ecole();
		ecole.setNom("Polytech Tours");
		ecole.setNbEleves(200);
		
		Ecole ecole2 = new Ecole();
		ecole2.setNom("Polytech Paris");
		ecole2.setNbEleves(380);
		
		Enseignant e1 = new Enseignant();
		e1.setFirstname("Wenli");
		e1.setLastname("YAN");
		e1.setNSS("aaaaa");
		e1.setEcole(ecole);
		
		Enseignant e2 = new Enseignant();
		e2.setFirstname("Junhong");
		e2.setLastname("QU");
		e2.setNSS("bbbbb");
		e2.setEcole(ecole);
		
		Adresse a = new Adresse();
		a.setNomRue("gaspard");
		a.setCodePostal("37200");
		a.setNomVille("Tours");
		a.setNumRue(6);
		

		
		em.getTransaction().begin();
		em.persist(ecole);//
		em.persist(a);
		em.persist(e1);
		em.persist(ecole2);//
		em.persist(e2);
		
		ecole.addEnseignant(e1);
		ecole.addEnseignant(e2);
		
		e1.setAdresse(a);
		e2.setAdresse(a);
		em.getTransaction().commit();

		

/*		em.getTransaction().begin();
		e1.setAdresse(a);
		e1.setEcole(ecole);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Enseignant en = em.find(Enseignant.class, 1);
		en.getAdresse().setNomRue("Leclerc");
		em.getTransaction().commit();
		
	*/	
		
/*------------------------6-----------------------------------*/
		em.getTransaction().begin();
	
		Scanner s = new Scanner(System.in);
		System.out.printf("Enterez le nom d'ecole pour chercher : ");
		String ecoleName = s.nextLine();
		Ecole e = em.find(Ecole.class, ecoleName);
		if(e == null){
			System.out.println("nononononono!!!!");
		}
		else{
			System.out.println("Le nombre d'etudiants est : "+e.getNbEleves());
		//------NOTE:Pour print une phrase et une variable, on a deux facons:
		//System.out.println("Le nombre d'etudiants est : ");
		//System.out.println(e.getNbEleves());
		
		
			System.out.println("Les enseignants : ");
		//facon 1
//		int nbEnseignant = e.getListeEnseignant().size();
//		for (int i = 0;i<nbEnseignant; i++ ){
//			//on cherche que les choses qu'on a besoin
//			System.out.println(e.getListeEnseignant().get(i).getLastname());
//		}

		//facon 2
			for (Enseignant enss : ecole.getListeEnseignant()) {
				System.out.println(enss.getLastname()+"\t"+enss.getNSS());
			}
		}

		
		em.getTransaction().commit();
		
/*------------------------7--------------------------------------*/
		em.getTransaction().begin();
		// trouver l'enseigant 
		Scanner ss = new Scanner(System.in);
		System.out.printf("Enterez le NSS d'un enseignant : ");
		int indexchercher = ss.nextInt();
		Enseignant enModifier = em.find(Enseignant.class, indexchercher);
		
		// saisir et creer nouvelle adresse
		ss= new Scanner(System.in);
		System.out.printf("Enterez une nouvelle ville de cet enseignant : ");
		String newVille = ss.nextLine(); 
		
		//--si on va ajouter une nouvelle ville pour l'enseigant
		Adresse newAD = new Adresse();
		newAD.setNomVille(newVille);
		enModifier.setAdresse(newAD);
		
		//--si on va juste modifier une nouvelle ville !!!!!!!!!!!!!!ca ne marche pas !!!!!!!!!!!
//		enModifier.getAdresse().setNomVille(newVille);
		
		//mise a jour l'adresse de cet enseignant
		em.merge(enModifier);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
