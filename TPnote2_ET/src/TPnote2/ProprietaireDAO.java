package TPnote2;

public class ProprietaireDAO {

	
	public static Proprietaire getProprieraireBynomP(String nomP)
	{
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		try
		{
			Proprietaire p = con.em.find(Proprietaire.class, nomP);
	
			System.out.println("nomProprietaire : "+ p.getNomProprietaire());
			System.out.println("adresseP : "+ p.getAdresseP());
			return p;

			
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// Error.
		System.out.println("Aucune proprietaire avec ce nom n'a ete trouve.");
		con.Tcommit(con.em);
		
		return null;
	}
	
	
	
	
	
	
	
	public static boolean ajouterProprietaire(String nomP, String adress) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);

		
		try
		{
			if(con.em.find(Proprietaire.class, nomP) == null){
				Proprietaire pr1 = new Proprietaire();
				pr1.setNomProprietaire(nomP);
				pr1.setAdresseP(adress);
				con.em.persist(pr1);
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
	
	
}
