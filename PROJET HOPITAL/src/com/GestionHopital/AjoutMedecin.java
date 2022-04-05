package com.GestionHopital;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class AjoutMedecin extends JFrame {
	private JPanel panelPrincipale = new JPanel();
	private JLabel lNom, lMatricule, lIcon1, bBienvenu1;
	private JTextField tNom, tMatricule;
	private JButton bAjouter, bSupprimer,bAfficher, bDispose;
	
	public AjoutMedecin(){
		this.setTitle("ADD DOCTOR");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setEnabled(true);
		this.setContentPane(panelPrincipale);
		initComportment();
		this.setVisible(true);
		
	}

	private void initComportment() {
		// TODO Auto-generated method stub
		GridLayout disposition = new GridLayout(5, 2, 5,5);
		panelPrincipale.setLayout(disposition);
		lNom = new JLabel(" NOM ");
		lMatricule = new JLabel(" MATRICULE");
		tNom = new JTextField(10);
		tMatricule = new JTextField(10);
		bAjouter = new JButton(" ADD ");
		bDispose = new JButton(" CANCEL ");
		bDispose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
		});
		bAfficher = new JButton(" DISPLAY ");
		bAfficher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AfficherMedecin af = new AfficherMedecin();
				
			}
			
		});
		bAjouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutMedecin(tMatricule.getText(), tNom.getText());
				//dispose();
				
				
			}

			private void AjoutMedecin(String Nom, String Matricule) {
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver");
					//Affichage de sa reussite
					System.out.println(" Diver Ok ");
					String bdd = "Votre base des données";
					String url = "jdbc:mysql://localhost/hopital";
					String user = "root";
					String passwd = "";
					Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
					System.out.println("Connection Effective");
					java.sql.Statement state = conn.createStatement();
					//String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values('20S1586', 'AKOBO Marthe')";
					//state.executeUpdate(requete);
					String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values(?, ? )";
					PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
					prepare.setString(1, Nom);
					prepare.setString(2, Matricule);
					System.out.println(prepare.toString());
					prepare.executeUpdate();
					
					prepare.close();
					state.close();
					
					
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("erreur detecter");
				}
				
				
				
			}
			
		});
		bSupprimer = new JButton(" RESET ");
		bSupprimer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tMatricule.setText("");
				tNom.setText("");
				
			}
			
		});
		Font police = new Font("Tahoma", Font.BOLD, 24);
		lMatricule.setFont(police);
		lMatricule.setForeground(Color.BLUE);
		lNom.setFont(police);
		lNom.setForeground(Color.BLUE);
		bAjouter.setFont(police);
		bAjouter.setForeground(Color.BLUE);
		bSupprimer.setFont(police);
		bSupprimer.setForeground(Color.RED);
		bDispose.setFont(police);
		bDispose.setForeground(Color.RED);
		bAfficher.setFont(police);
		bAfficher.setForeground(Color.BLUE);
		
		
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img16.PNG"));
		bBienvenu1 = new JLabel("AJOUTEZ UN MEDECIN");
		Font pol = new Font("Tahoma", Font.BOLD, 24);
		bBienvenu1.setFont(pol);
		bBienvenu1.setForeground(Color.MAGENTA);
		
		
		panelPrincipale.add(lNom);
		panelPrincipale.add(tNom);
		panelPrincipale.add(lMatricule);
		panelPrincipale.add(tMatricule);
		panelPrincipale.add(bAjouter);
		panelPrincipale.add(bSupprimer);
		panelPrincipale.add(bDispose);
		panelPrincipale.add(bAfficher);
		panelPrincipale.add(lIcon1);
		panelPrincipale.add(bBienvenu1);
		
		
		
		
		/*panelPrincipale.setLayout(null);
		lNom = new JLabel(" NOM ");
		lNom.setBounds(5, 3, 120, 25);
		lMatricule = new JLabel(" MATRICULE");
		lMatricule.setBounds(5, 35, 120, 25);
		
		tNom = new JTextField(10);
		tNom.setBounds(130, 3, 120, 25);
		tMatricule = new JTextField(10);
		tMatricule.setBounds(130, 35, 120, 25);
		
		bAjouter = new JButton(" ADD ");
		bAjouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutMedecin(tMatricule.getText(), tNom.getText());
				dispose();
			}

			private void AjoutMedecin(String Nom_M, String Matricule) {
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver");
					//Affichage de sa reussite
					System.out.println(" Diver Ok ");
					String bdd = "Votre base des données";
					String url = "jdbc:mysql://localhost/gestionhosoitaliere";
					String user = "root";
					String passwd = "";
					Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
					System.out.println("Connection Effective");
					java.sql.Statement state = conn.createStatement();
					//String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values('20S1586', 'AKOBO Marthe')";
					//state.executeUpdate(requete);
					String requete = "INSERT INTO medecin(`Matricule`,`Nom_M`)values(?, ? )";
					PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
					prepare.setString(1, Nom_M);
					prepare.setString(2, Matricule);
					System.out.println(prepare.toString());
					prepare.executeUpdate();
					
					prepare.close();
					state.close();
					
					
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("erreur detecter");
				}
				
				
			}
			
		});
		bAjouter.setBounds(5, 65, 120, 25);
		bSupprimer = new JButton(" RESET ");
		bSupprimer.setBounds(130, 65, 120, 25);
		
		panelPrincipale.add(lNom);
		panelPrincipale.add(tNom);
		panelPrincipale.add(lMatricule);
		panelPrincipale.add(tMatricule);
		panelPrincipale.add(bAjouter);
		panelPrincipale.add(bSupprimer);
		
		*/
	}
	

}
