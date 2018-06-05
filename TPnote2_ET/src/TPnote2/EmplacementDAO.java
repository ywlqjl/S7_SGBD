package TPnote2;

public class EmplacementDAO {
	
	
	public static Emplacement getEmplacmentBycodeE(int codeE)
	{
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		
		try
		{
			Emplacement e = con.em.find(Emplacement.class, codeE);
			return e;
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// Error.
		System.out.println("Aucune Emplacement avec ce codeQuai n'a ete trouve.");
		con.Tcommit(con.em);
		
		return null;
	}
	
	

	
	public static boolean ajouterEmplacement(int codeE, int taille, Quai quai, Bateau bateau) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);

		try
		{
			if(con.em.find(Emplacement.class, codeE) == null){
				Emplacement e1 = new Emplacement();
				e1.setCodeE(codeE);
				e1.setTailleE(taille);
				e1.setQuai(quai);
				e1.setBateau(bateau);
				con.em.persist(e1);
				con.Tcommit(con.em);
				return true;
			}
			else{ 
				// Error.
				System.out.println("Le Emplacement existe deja.");
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
	
	
	
}
