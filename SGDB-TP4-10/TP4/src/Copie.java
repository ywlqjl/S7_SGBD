
public class Copie
{
	private Livre livre;
	private Integer numero;
	
	public Copie(Livre livre, Integer numero)
	{
		this.livre = livre;
		this.numero = numero;
	}

	/**
	 * @return the livre
	 */
	public Livre getLivre() {
		return livre;
	}

	/**
	 * @param livre the livre to set
	 */
	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
}
