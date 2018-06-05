
public class Utilisateur
{
	int idUtilisateur; 
	String Nom; 
	String Prenom; 
	String Email; 
	String Motdepasse; 

	public Utilisateur(int idUtilisateur, String Nom, String Prenom, String Email, String Motdepasse)
	{
		this.idUtilisateur = idUtilisateur;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Email = Email;
		this.Motdepasse = Motdepasse;
	}

	public int getidUtilisateur()
	{
		return idUtilisateur;
	}

	
	public void setidUtilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
	}


	public String getNom()
	{
		return Nom;
	}

	public void setNom(String Nom)
	{
		this.Nom = Nom;
	}


	public String getPrenom()
	{
		return Prenom;
	}


	public void setPrenom(String Prenom)
	{
		this.Prenom = Prenom;
	}
	
	public String getEmail()
	{
		return Email;
	}


	public void setEmail(String Email)
	{
		this.Email = Email;
	}

	public String getMotdepasse()
	{
		return Motdepasse;
	}


	public void setMotdepasse(String Motdepasse)
	{
		this.Motdepasse = Motdepasse;
	}
	
}
