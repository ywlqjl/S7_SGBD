/*
 *	Note:  win.setVisible(true); 要放在最后面 才能正常显示
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class View {

	JMenuBar barMenu = new JMenuBar();
	JMenu menuLivre = new JMenu("Livre");
	JMenu menuAssocie = new JMenu("Associés");
	JMenu menuEmprunts = new JMenu("Emprunts");
	
	JMenuItem ajoutLivre = new JMenuItem("Ajouter un livre");
	JMenuItem supprimerLivre = new JMenuItem("Supprimer livre");
	JMenuItem consulterLivre = new JMenuItem("Consulter livre");
	JMenuItem ajoutCopieLivre = new JMenuItem("Ajouter copie d'un livre");
	JMenuItem retirerCopieLivre = new JMenuItem("Retirer copie d'un livre");
	
	JMenuItem ajoutAssocie = new JMenuItem("Ajouter un associé");
	JMenuItem retirerAssocie = new JMenuItem("Retirer un associé");
	
	JMenuItem empruntLivre = new JMenuItem("Emprunter un livre");
	JMenuItem retourLivre = new JMenuItem("Retourner un livre");
	
	public void createWindow() {
		//Main window
		JFrame win = new JFrame(); 
	    win.setTitle("Bibliothèque de livres");
	    win.setSize(1000, 800);
	    win.setLocationRelativeTo(null);
	    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    win.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				ConnectionDAO.close();
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
	    }
	    );
	 //   win.setVisible(true);
		
	    //Menu
	    barMenu.add(menuLivre);
	    barMenu.add(menuAssocie);
	    barMenu.add(menuEmprunts);
	    
	    //Add the item of the livre menu 
	    menuLivre.add(ajoutLivre);
	    menuLivre.add(supprimerLivre);
	    menuLivre.add(consulterLivre);
	    menuLivre.addSeparator();
	    menuLivre.add(ajoutCopieLivre);
	    menuLivre.add(retirerCopieLivre);
	    
	    //Add the item of the associe menu 
	    menuAssocie.add(ajoutAssocie);
	    menuLivre.add(retirerAssocie);

	    //Add the item of the emprunts menu 
	    menuEmprunts.add(empruntLivre);
	    menuEmprunts.add(retourLivre);
	    
	    //Listener on the item menu 
	    ajoutLivre.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Entrer un livre
				String ISBN = (String)JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre à ajouter :", "Ajout d'un Livre", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String description = (String)JOptionPane.showInputDialog(null, "Entrez la description du livre a ajouter :", "Ajout d'un Livre", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String sujet = (String)JOptionPane.showInputDialog(null, "Entrez le sujet du livre à ajouter :", "Ajout d'un Livre", JOptionPane.PLAIN_MESSAGE, null, null, "");
				
				boolean success = LivreDAO.addLivre(ISBN, description, sujet);
				
				if(success)
					JOptionPane.showMessageDialog(null, "Livre " + ISBN + " ajoute.");
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter le livre, le livre existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
				
			}
	    });

	    ajoutCopieLivre.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Entrer un livre
				String ISBN = (String)JOptionPane.showInputDialog(null, "Entrez l'ISBN du livre à ajouter :", "Ajout d'un Livre", JOptionPane.PLAIN_MESSAGE, null, null, "");

				boolean success = CopieDAO.addCopyOfBook(ISBN);
				
				if(success)
					JOptionPane.showMessageDialog(null, "Copie du livre " + ISBN + " ajoutée.");
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter la copie.", "Erreur", JOptionPane.ERROR_MESSAGE);
				
			}
	    });
	    
	    win.setJMenuBar(barMenu);
	    win.setVisible(true);
	}
}
