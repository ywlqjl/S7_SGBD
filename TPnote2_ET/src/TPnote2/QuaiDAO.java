package TPnote2;
import java.util.List;
import javax.persistence.Query;

public class QuaiDAO {

	
	public static Quai getQuaiBycodeQ(int codeQ)
	{
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		try
		{
			Quai q = con.em.find(Quai.class, codeQ);
			return q;
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// Error.
		System.out.println("Aucune quai avec ce codeQuai n'a ete trouve.");
		con.Tcommit(con.em);
		
		return null;
	}
	
	

	
	public static boolean ajouterQuai(int codeQ, int nbEmplacement) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);

		
		try
		{
			if(con.em.find(Quai.class, codeQ) == null){
				Quai q1 = new Quai();
				q1.setCodeQ(codeQ);
				q1.setNbEmplacement(nbEmplacement);
				con.em.persist(q1);
				con.Tcommit(con.em);
				return true;
			}
			else{ 
				// Error.
				System.out.println("Le quai existe deja.");
				return false;
			}
		}
		
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return false;
		
	}
/*	
// facon 2: JPA 	
	public static void nbDeQuai(int codeQ) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		System.out.println("hello");
		
		String queryString1 = "SELECT Emplacement.quai_codeQ,COUNT(Bateau.idBateau)AS nbBateauPresent FROM Emplacement join Bateau on Emplacement.codeE = Bateau.emplacement_codeE  WHERE Emplacement.quai_codeQ = ?1";
		String queryString = "select emplacement_codeE from Bateau ";// ok
		Query query = con.em.createQuery(queryString);
		System.out.println("111111111");
		query.setParameter(1, codeQ);
		List results = query.getResultList();
//		Object[] firstResult = (Object[])results.get(0);
		for (int i = 0; i < results.size(); i++) {
			Object[] ob =  (Object[])results.get(i);
			int q = (int) ob[0];
			int nb = (int) ob[1];
		    System.out.println("Quai:"+ob[0]+"Nb"+ob[1]);
		    
		}
	}
	
	*/
	
	
	//facon 1: calcul par getBateau()
	public static int nbBateauDeQuai(int codeQ){
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		

		try
		{
			Quai q = con.em.find(Quai.class, codeQ);
			int nbBateauDeQuai = 0;
			if( q != null){
				for(int i = 0; i<q.getListeEmplacement().size(); i++){
					if(q.getListeEmplacement().get(i).getBateau()!=null){
						nbBateauDeQuai++;
					}
				}
				return nbBateauDeQuai;
			}
			else{ 
				// Error.
				System.out.println("Le quai n'existe pas.");
				return 0;
			}
		}
		
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return 0;
		
	}

	
	
	/*
	 * donne codeQ, return nbE de voile leauel sa suface > un nombre donne.
	 * param int codeQ, double surfaceVoile
	 * return nb le nombre de Voile
	 */
	public static int Question2(int codeQ, double surfaceVoile){
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		
		try
		{
			Quai q = con.em.find(Quai.class, codeQ);
			int command = 0;
			if( q != null){

				String queryString = "select idBateau, surfaceVoile from Voile where surfaceVoile > ?1";
				Query query = con.em.createQuery(queryString);
				query.setParameter(1, surfaceVoile);

				List results = query.getResultList();

				for (int i = 0; i < results.size(); i++) {
					Object[] ob =  (Object[])results.get(i);
					
					int idB = (int) ob[0];
					double surface = (double)ob[1];
				    System.out.println("idB:"+idB+"surface"+surface);
				    if( BateauDAO.getBateauByidBateau(idB).getEmplacement().getQuai().getCodeQ() == codeQ){
				    	command ++;
				    }
				 } 
				
				
				return command;
				
			}
			else{ 
				// Error.
				System.out.println("Le quai n'existe pas.");
				return 0;
			}
		}
		
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return 0;
		
	}
	
}
