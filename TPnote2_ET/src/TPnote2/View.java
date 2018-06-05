package TPnote2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class View {
	

	JMenuBar barMenu = new JMenuBar();
	JMenu menuQuai = new JMenu("Quai");
	JMenu menuBateaux = new JMenu("Bateaux");
	JMenu menuProprietaire = new JMenu("Proprietaire");
	JMenu extra = new JMenu("Extra");

	
	JMenuItem ajouterQuai = new JMenuItem("Ajouter un quai");
	JMenuItem supprimerQuai = new JMenuItem("Supprimer un quai");
	JMenuItem consulterQuai = new JMenuItem("Consulter quai");
	JMenuItem ajouterEmplacement = new JMenuItem("Ajouter un emplacement d'un quai");
	JMenuItem supprimerEmplacement = new JMenuItem("Supprimer un emplacement d'un quai");
	JMenuItem consulterEmplacement = new JMenuItem("Consulter un emplacement d'un quai");
	
	JMenuItem ajouterVoile = new JMenuItem("Ajouter un bateaux a voile");
	JMenuItem supprimerVoile = new JMenuItem("Supprimer un bateaux a voile");
	JMenuItem ajouterMoteur = new JMenuItem("Ajouter un bateaux a moteur");
	JMenuItem supprimerMoteur = new JMenuItem("Supprimer un bateaux a moteur");	
	JMenuItem consulterBateaux = new JMenuItem("Consulter un bateaux");
	
	JMenuItem ajouterProprietaire = new JMenuItem("Ajouter une proprietaire");
	JMenuItem supprimerProprietaire = new JMenuItem("Supprimer une proprietaire");
	JMenuItem consulterProprietaire = new JMenuItem("Consulter proprietaire");
	
	JMenuItem nbBateauPresentDeQuai = new JMenuItem("nbBateauPresent De Quai");
	JMenuItem nbVoileDeQuai = new JMenuItem("nbVoile surface limite De Quai");
	JMenuItem nbEdisponibleDeQuai = new JMenuItem("nb Emplacement disponible De Quai");

	public void quaiResult(Quai q){
		
		JFrame winResults = new JFrame(); 

		winResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winResults.setVisible(true);
		winResults.setSize(400, 200);
		winResults.setLayout(new java.awt.GridLayout(0, 1));
		winResults.setLocation(300,200);
		
		winResults.add(new JLabel("******************** Infomation de Quai ************************"));
		winResults.add(new JLabel("		codeQuai:		"+q.getCodeQ()));
		winResults.add(new JLabel("		NbEmplacement:	"+q.getNbEmplacement()));
		winResults.add(new JLabel("*****************************************************************"));
		
	}
	
	//pour facon1 
	public void quaiResult2(Quai q, int nb){
		
		JFrame winResults = new JFrame(); 

		winResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winResults.setVisible(true);
		winResults.setSize(600, 200);
		winResults.setLayout(new java.awt.GridLayout(0, 1));
		winResults.setLocation(300,200);
		
		winResults.add(new JLabel("************************* Infomation de Quai **************************"));
		winResults.add(new JLabel("	Question: Etant donné un quai, retourner le nombre de bateaux présents:	"));
		winResults.add(new JLabel("		codeQuai	   :		"+q.getCodeQ()));
		winResults.add(new JLabel("		NbBateauPresent:		"+nb));
		winResults.add(new JLabel("***********************************************************************"));

	}
	//pour facon2
	public void quaiResult3(int codeInt, int nbE){
		
		JFrame winResults = new JFrame(); 

		winResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winResults.setVisible(true);
		winResults.setSize(600, 200);
		winResults.setLayout(new java.awt.GridLayout(0, 1));
		winResults.setLocation(300,200);
		
		winResults.add(new JLabel("************************* Infomation de Quai **************************"));
		winResults.add(new JLabel("	Question: Etant donné un quai, retourner le nombre d'emplacement attribués à des "));
		winResults.add(new JLabel("	bateaux à voile avec surface supérieure à une valeur donnée par l'utilisateur:	"));
		winResults.add(new JLabel("		codeQuai:					"+codeInt));
		winResults.add(new JLabel("		NbEmplacement attribue:		"+nbE));
		winResults.add(new JLabel("************************************************************************"));

	}
	
	

	
	
	public void createWindow() {
		//Main window

		JFrame win = new JFrame(); 
	    win.setTitle("Gestion des quais d'un port de plaisance");
	    win.setSize(800, 600);
	    win.setLocationRelativeTo(null);
	    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    win.getContentPane();//

	   
	    win.addWindowListener(new WindowListener() {
	    

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		
	    }
	    );

	    
	    
	    
	    
	    
	    
	    //Menu
	    barMenu.add(menuQuai);
	    barMenu.add(menuBateaux);
	    barMenu.add(menuProprietaire);
	    barMenu.add(extra);
	    
	    //Add the item of the Quai menu 
	    menuQuai.add(ajouterQuai);
	    menuQuai.add(supprimerQuai);
	    menuQuai.add(consulterQuai);
	    menuQuai.addSeparator();
	    menuQuai.add(ajouterEmplacement);
	    menuQuai.add(supprimerEmplacement);
	    menuQuai.add(consulterEmplacement);
	    
	    //Add the item of the Bateaux menu 
	    menuBateaux.add(ajouterVoile);
	    menuBateaux.add(supprimerVoile);
	    menuBateaux.add(ajouterMoteur);
	    menuBateaux.add(supprimerMoteur);
	    menuBateaux.add(consulterBateaux);

	    //Add the item of the Proprietaire menu 
	    menuProprietaire.add(ajouterProprietaire);
	    menuProprietaire.add(supprimerProprietaire);
	    menuProprietaire.add(consulterProprietaire);
	    
	    //Add the item of the Extra menu 
	    extra.add(nbBateauPresentDeQuai);
		extra.add(nbVoileDeQuai);
  
	    //Listener on the item menu 
		
/*
 * Operations Bateau
 */
	    ajouterVoile.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int idB = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Entrez le id du bateau:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				String nomB = (String)JOptionPane.showInputDialog(null, "Entrez le nom du bateau:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, "");
				double surfaceVoile = Double.parseDouble((String)JOptionPane.showInputDialog(null, "Entrez le surface de voile:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));				
				double poids = Double.parseDouble((String)JOptionPane.showInputDialog(null, "Entrez le poids du bateau:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				String nomP = (String)JOptionPane.showInputDialog(null, "Entrez le nom de la proprietaire de voile:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, "");				
				int codeE = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Entrez le codeE:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				if(EmplacementDAO.getEmplacmentBycodeE(codeE)==null){
					JOptionPane.showMessageDialog(null, "l'emplacement n'existe pas, choisir l'autre emplacment.");
				}
				else{
					if(EmplacementDAO.getEmplacmentBycodeE(codeE).getBateau()==null){
						boolean success = BateauDAO.ajouterVoile(idB, nomB, poids,surfaceVoile, ProprietaireDAO.getProprieraireBynomP(nomP), EmplacementDAO.getEmplacmentBycodeE(codeE));
						
						if(success)
							JOptionPane.showMessageDialog(null, "Bateau " + idB + " ajoute.");
						else
							JOptionPane.showMessageDialog(null, "Impossible d'ajouter le bateau, le bateau existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Il y a deja un bateau dans cet emplacement.");

					}
			
				}
		
			}
	    });
	    
	    
	    ajouterMoteur.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int idB = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Entrez le id du bateau :", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				String nomB = (String)JOptionPane.showInputDialog(null, "Entrez le nom du bateau :", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int nbChevauxVapeur = Integer.parseInt((String)JOptionPane.showInputDialog(null, "Entrez le nbChevauxVapeur de voile :", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));				
				double poids = Double.parseDouble((String)JOptionPane.showInputDialog(null, "Entrez le poids du bateau :", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				String nomP = (String)JOptionPane.showInputDialog(null, "Entrez le nom de la proprietaire de ce moteur:", "Ajout d'un bateau", JOptionPane.PLAIN_MESSAGE, null, null, "");				

				
				boolean success = BateauDAO.ajouterMoteur(idB, nomB, poids , nbChevauxVapeur, ProprietaireDAO.getProprieraireBynomP(nomP));
				if(success)
					JOptionPane.showMessageDialog(null, "Bateau " + idB + " ajoute.");
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter le bateau, le bateau existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	    
/*
 * Operations proprieraire
 * 	    
 */
	    ajouterProprietaire.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nomP = (String)JOptionPane.showInputDialog(null, "Entrez le nom du proprietaire à ajouter :", "Ajout d'un proprietaire", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String adress = (String)JOptionPane.showInputDialog(null, "Entrez l'adresse du proprietaire à ajouter :", "Ajout d'un proprietaire", JOptionPane.PLAIN_MESSAGE, null, null, "");

				
				boolean success = ProprietaireDAO.ajouterProprietaire(nomP, adress);
				if(success)
					JOptionPane.showMessageDialog(null, "proprietaire " + nomP + " ajoute.");
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter le proprietaire, le proprietaire existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	    
/*
 * Operations quai
 * 
 */
	    ajouterQuai.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//deux facons pour changer le type de String a Integer:
				String codeQ = (String) JOptionPane.showInputDialog(null, "Entrez le code du quai à ajouter :", "Ajout d'un quai", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int nbEmplacement = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le nombre de quai a ajouter :", "Ajout d'un quai", JOptionPane.PLAIN_MESSAGE, null, null, ""));				
				int codeQint = Integer.parseInt(codeQ);
				
				boolean success = QuaiDAO.ajouterQuai(codeQint, nbEmplacement);
				if(success){
					JOptionPane.showMessageDialog(null, "Quai " + codeQint + " ajoute.");
				}
				else
					JOptionPane.showMessageDialog(null, "Impossible d'ajouter le quai, le quai existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	    
	    
	    ajouterEmplacement.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int codeE = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le code de l'Emplacement à ajouter, [format:codeQ+'0'+codeE]:", "Ajout d'un Emplacement", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				if(EmplacementDAO.getEmplacmentBycodeE(codeE)!=null){
					JOptionPane.showMessageDialog(null, "L'emplacement existe deja!");
				}
				else{
					int tailleE = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez la taille de l'Emplacement a ajouter :", "Ajout d'un Emplacement", JOptionPane.PLAIN_MESSAGE, null, null, ""));				
					int codeQ = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le codeQ de cet Emplacement :", "Ajout d'un Emplacement", JOptionPane.PLAIN_MESSAGE, null, null, ""));				

					if(QuaiDAO.getQuaiBycodeQ(codeQ)==null){
						JOptionPane.showMessageDialog(null, "Le quai n'existe pas!");
					}
					else{
						int idBateau = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le idBateau de cet Emplacement :", "Ajout d'un Emplacement", JOptionPane.PLAIN_MESSAGE, null, null, ""));				

						boolean success = EmplacementDAO.ajouterEmplacement(codeE, tailleE, QuaiDAO.getQuaiBycodeQ(codeQ), BateauDAO.getBateauByidBateau(idBateau) );
						if(success)
							JOptionPane.showMessageDialog(null, "Emplacement " + codeE + " ajoute.");
						else
							JOptionPane.showMessageDialog(null, "Impossible d'ajouter l'Emplacement, l'Emplacement existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
						
				}

			}
	    });
	    
	    
	    consulterQuai.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String codeQ = (String) JOptionPane.showInputDialog(null, "Entrez le code du quai à chercher :", "chercher quai", JOptionPane.PLAIN_MESSAGE, null, null, "");
	    		int codeQint = Integer.parseInt(codeQ);
		
				System.out.println("codeQint:"+codeQint);
				//////////////////////////!!!!!
				Quai q = QuaiDAO.getQuaiBycodeQ(codeQint);
				if(q!=null){

					quaiResult(QuaiDAO.getQuaiBycodeQ(codeQint));
//					labels[0].setText("BOTTOM "+" : ");
				}
				else
					JOptionPane.showMessageDialog(null, "Ne pouvez pas le trouver.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	
	    
	    
/*
 * des operations extras.
 *  
 */
	    nbBateauPresentDeQuai.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cherher un quai
				String codeQ = (String) JOptionPane.showInputDialog(null, "Entrez le code du quai à chercher :", "chercher quai", JOptionPane.PLAIN_MESSAGE, null, null, "");
	    		int codeQint = Integer.parseInt(codeQ);
		
				System.out.println("codeQint:"+codeQint);
				//////////////////////////!!!!!
				Quai q = QuaiDAO.getQuaiBycodeQ(codeQint);
				if(q!=null){

					quaiResult2(QuaiDAO.getQuaiBycodeQ(codeQint), QuaiDAO.nbBateauDeQuai(codeQint));
//					labels[0].setText("BOTTOM "+" : ");
				}
				else
					JOptionPane.showMessageDialog(null, "Ne pouvez pas le trouver.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	    
// façon 2
//	    nbBateauPresentDeQuai.addActionListener(new ActionListener()
//	    {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//
//				int codeQint = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le code du quai à chercher :", "chercher quai", JOptionPane.PLAIN_MESSAGE, null, null, ""));
//				Quai q = QuaiDAO.getQuaiBycodeQ(codeQint);
//				
//				if(q!=null){
//					quaiResult3(codeQint, QuaiDAO.nbDeQuai(codeQint));
//				}
//				else
//					JOptionPane.showMessageDialog(null, "Ne pouvez pas le trouver.", "Erreur", JOptionPane.ERROR_MESSAGE);
//			}
//	    });
	    
	    
	    nbVoileDeQuai.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//cherher un quai
				int codeQint = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le code du quai à chercher :", "chercher quai", JOptionPane.PLAIN_MESSAGE, null, null, ""));
				double surfaceVoile = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Entrez la surface limite du voile à chercher :", "SurfaceLimite", JOptionPane.PLAIN_MESSAGE, null, null, ""));

				Quai q = QuaiDAO.getQuaiBycodeQ(codeQint);
				if(q!=null){

					quaiResult3(codeQint, QuaiDAO.Question2(codeQint, surfaceVoile));
				}
				else
					JOptionPane.showMessageDialog(null, "Pas resultat.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
	    });
	    
	    
//	    nbEdisponibleDeQuai.addActionListener(new ActionListener()
//	    {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				//cherher un quai
//				int codeQint = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Entrez le code du quai à chercher :", "chercher quai", JOptionPane.PLAIN_MESSAGE, null, null, ""));
//				double surfaceVoile = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Entrez la surface limite du voile à chercher :", "SurfaceLimite", JOptionPane.PLAIN_MESSAGE, null, null, ""));
//
//				Quai q = QuaiDAO.getQuaiBycodeQ(codeQint);
//				if(q!=null){
//
//					quaiResult3(codeQint, QuaiDAO.Question2(codeQint, surfaceVoile));
//				}
//				else
//					JOptionPane.showMessageDialog(null, "Pas resultat.", "Erreur", JOptionPane.ERROR_MESSAGE);
//			}
//	    });
	    
	    
	    
	    win.setJMenuBar(barMenu);
	    win.setVisible(true);
	    
	}
}
