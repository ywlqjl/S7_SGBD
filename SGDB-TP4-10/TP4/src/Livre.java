
public class Livre
{
	String ISBN; 
	String description; 
	String sujet; 
	Integer NCopies;

	public Livre(String ISBN, String description, String sujet, Integer NCopies)
	{
		this.ISBN = ISBN;
		this.description = description;
		this.sujet = sujet;
		this.NCopies = NCopies;
	}

	/**
	 * @return the ISBN
	 */
	public String getISBN()
	{
		return ISBN;
	}

	/**
	 * @param ISBN the ISBN to set
	 */
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the sujet
	 */
	public String getSujet()
	{
		return sujet;
	}

	/**
	 * @param sujet the sujet to set
	 */
	public void setSujet(String sujet)
	{
		this.sujet = sujet;
	}

	/**
	 * @return the nCopies
	 */
	public Integer getNCopies()
	{
		return NCopies;
	}

	/**
	 * @param nCopies the nCopies to set
	 */
	public void setNCopies(Integer nCopies)
	{
		NCopies = nCopies;
	}
}
