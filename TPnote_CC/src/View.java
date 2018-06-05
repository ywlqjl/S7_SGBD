

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
	JMenu menuUtilisateur = new JMenu("Utilisateur");
	JMenu menuAnnonce = new JMenu("Annonce");
	
	JMenuItem enregistrerU = new JMenuItem("EnregistrerU");
	JMenuItem login = new JMenuItem("Login");
	JMenuItem ajouterAnnonce = new JMenuItem("Ajouter Annonce");
	JMenuItem modifierAnnonce = new JMenuItem("ModifierAnnonce");
	JMenuItem suppprimerAnnonce = new JMenuItem("SuppprimerAnnonce");
	JMenuItem chercherAnnonce = new JMenuItem("ChercherAnnonce");
	

	
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
	    barMenu.add(menuUtilisateur);
	    barMenu.add(menuAnnonce);
	    
	    menuUtilisateur.add(enregistrerU);
	    menuUtilisateur.add(login);
	    menuUtilisateur.add(ajouterAnnonce);
	    menuUtilisateur.add(modifierAnnonce);
	    menuUtilisateur.add(suppprimerAnnonce);
	    menuUtilisateur.add(chercherAnnonce);
	    menuUtilisateur.addSeparator();
	 
	    
	    //Listener on the item menu 
	    ajouterAnnonce.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int idAnnonce = (int)JOptionPane.showInputDialog(null, "Entrez  :", "idAnnonce ", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String Titre = (String)JOptionPane.showInputDialog(null, "Entrez  :", "Titre", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String TransactionType = (String)JOptionPane.showInputDialog(null, "Entrez  :", "TransactionType", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String Position = (String)JOptionPane.showInputDialog(null, "Entrez  :", "Position", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String Categorie = (String)JOptionPane.showInputDialog(null, "Entrez  :", "Categorie", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String Prix = (String)JOptionPane.showInputDialog(null, "Entrez  :", "Prix", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String Description = (String)JOptionPane.showInputDialog(null, "Entrez  :", "Description", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int idUtilisateur = (int)JOptionPane.showInputDialog(null, "Entrez  :", "idUtilisateur ", JOptionPane.PLAIN_MESSAGE, null, null, "");

				
				boolean success = AnnonceDAO.addAnnonce(idAnnonce, Titre, TransactionType, Position, Categorie, Prix, Description, idUtilisateur);
				
				if(success)
					JOptionPane.showMessageDialog(null, "Annonce " + idAnnonce + " ajoute.");
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter , existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
				
			}
	    });

	    
	    win.setJMenuBar(barMenu);
	    win.setVisible(true);
	}
}
