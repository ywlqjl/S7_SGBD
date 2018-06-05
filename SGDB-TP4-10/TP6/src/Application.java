import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Application {
	
	
	
	private static Scanner reader;

	public static void main(String[] args) {
		
		// 1 : Ouverture unite de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet metier 添加数据:给数据
		Employeur emp = new Employeur(0, "Neron", "Emmanuel","30/08/1992",100000.9);
		Employeur a = new Employeur(1, "Nahb", "Emmanuh","30/09/1992",210001.9);
		 
		// 4 : Persistance Objet/Relationnel : creation d'un enregistrement en base  添加数据：方法persist()
		 em.persist(emp); em.persist(a);
		 
/*		 
		// ----find 查询数据 根据ID
		 System.out.println("Entrez ID de l'employeur que vous voulez modifier:");
		 reader = new Scanner(System.in);
		 int id = reader.nextInt();
		 Employeur modifier =em.find(Employeur.class,id);
		// System.out.print("id:"+modifier.getNom());
		 
		 
		// ----更新数据 merge()
		 
		 reader = new Scanner(System.in);
		 System.out.println("Entrez le nouveau salaire de l'employeur:"+modifier.getId());
		 double newSalaire;
		 newSalaire = Double.parseDouble(reader.nextLine());
		 System.out.println("键盘输入的内容是："+newSalaire);  
	      
		 modifier.setSalaire(newSalaire);
		 em.merge(modifier);
	
*/
		// ----删除un employeur 方法：remove()
		 System.out.println("Entrez ID de l'employeur que vous voulez supprimer:");
		 reader = new Scanner(System.in);
		 int id2 = reader.nextInt();
		 Employeur supprimer =em.find(Employeur.class,id2);
		 em.remove(supprimer);
		 
		 
		// 5 : Fermeture transaction 
		 tx.commit();
		
		// 6 : Fermeture unite de travail JPA 
		em.close();
		emf.close();	
	}

	
}
