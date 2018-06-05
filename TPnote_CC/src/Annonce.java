
public class Annonce
{
	private Integer idAnnonce;
	private String Titre;
	private String TransactionType;
	private String Position;
	private String Categorie;
	private String Prix;
	private String Description;
	private Integer idUtilisateur;
	
	public Annonce(int idAnnonce, String Titre, String TransactionType, String Position,String Categorie,String Prix,String Description,Integer idUtilisateur )
	{
		this.idAnnonce = idAnnonce;
		this.Titre = Titre;
		this.TransactionType = TransactionType;
		this.Position = Position;
		this.Categorie = Categorie;
		this.Prix = Prix;
		this.Description = Description;
		this.idUtilisateur = idUtilisateur;
		
	}

	public int getidAnnonce() {
		return idAnnonce;
	}

	public void setidAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String Titre) {
		this.Titre = Titre;
	}
	
	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String TransactionType) {
		this.TransactionType = TransactionType;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String Position) {
		this.Position = Position;
	}
	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String Categorie) {
		this.Categorie = Categorie;
	}
	public String getPrix() {
		return Prix;
	}

	public void setPrix(String Prix) {
		this.Prix = Prix;
	}
	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public int getidUtilisateur() {
		return idUtilisateur;
	}

	public void setidUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	
	
}
