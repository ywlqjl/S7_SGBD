package TPnote2;

public class BateauDAO {
	
	
	public static Bateau getBateauByidBateau(int idBateau)
	{
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);
		try
		{
			Bateau b = con.em.find(Bateau.class, idBateau);
			return b;
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// Error.
		System.out.println("Aucune Bateau avec cet idBateau n'a ete trouve.");
		con.Tcommit(con.em);
		
		return null;
	}
	
	

	
	public static boolean ajouterVoile(int idB, String nomB, double poids, double surfaceVoile, Proprietaire p, Emplacement ep) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);

		try
		{
			if(con.em.find(Voile.class, idB) == null){
				Voile v1 = new Voile();
				v1.setIdBateau(idB);
				v1.setNomBateau(nomB);
				v1.setPoids(poids);
				v1.setSurfaceVoile(surfaceVoile);
				v1.setProprietaire(p);
				v1.setEmplacement(ep);
				con.em.persist(v1);
				con.Tcommit(con.em);
				return true;
			}
			else{ 
				// Error.
				System.out.println("Le Voile existe deja.");
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

	
	
	public static boolean ajouterMoteur(int idB, String nomB, double poids, int nbChevauxVapeur, Proprietaire proprietaire) 
	{
		
		ConnectionDAO con = new ConnectionDAO();
		con.connection();
		con.Tbegin(con.em);

		try
		{
			if(con.em.find(Moteur.class, idB) == null){
				Moteur m1 = new Moteur();
				m1.setIdBateau(idB);
				m1.setNomBateau(nomB);
				m1.setPoids(poids);
				m1.setNbChevauxVapeur(nbChevauxVapeur);
				m1.setProprietaire(proprietaire);
				con.em.persist(m1);
				con.Tcommit(con.em);
				return true;
			}
			else{ 
				// Error.
				System.out.println("Le Moteur existe deja.");
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
