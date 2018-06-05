

public class Main
{
	public static void main(String[] args)
	{
		ConnectionDAO.init();
		Table_SQL.createTables();
		
//		//Entrer une copie d'un livre
//		String ISBN = (String)JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre a ajouter :", "Ajout d'une copie", JOptionPane.PLAIN_MESSAGE, null, null, "");
//		boolean success = CopieDAO.addCopyOfBook(ISBN);
//		
//		if(success)
//			JOptionPane.showMessageDialog(null, "Copie du livre " + ISBN + " ajoutee.");
//		else
//			JOptionPane.showMessageDialog(null, "Impossible d'ajouter la copie, le livre n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
		
		View view = new View(); 
		view.createWindow();
	
	}
}
