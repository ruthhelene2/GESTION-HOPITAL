package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class AjoutInfirmier extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JLabel lNom, lMatricule;
	private JTextField tNom, tMatricule;
	private JButton bAdd, bAnnuler, bDispose, bAfficher;
	private JPanel panInfirmier1, panInfirmier;
	private JLabel lIcon1, lIcon2;
	
	
	public AjoutInfirmier(){
		this.setTitle("ADD NURSE");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(panelPrincipale);
		initComportment();
		this.setVisible(true);
	}


	private void initComportment() {
		// TODO Auto-generated method stub
		
		panInfirmier1 = new JPanel();
		GridLayout disposition = new GridLayout(4, 2, 5, 5);
		panInfirmier1.setLayout(disposition);
		lMatricule = new JLabel("Matricule");
		tMatricule = new JTextField(10);
		lNom = new JLabel("Nom");
		tNom = new JTextField(10);
		bAdd = new JButton("ADD");
		bAnnuler = new JButton("RESET");
		bDispose = new JButton("CANCEL");
		bDispose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
		});
		bAfficher = new JButton("DISPLAY");
		bAfficher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FicheInfirmier fich = new FicheInfirmier();
				
				
			}
			
		});
		panInfirmier1.add(lMatricule);
		panInfirmier1.add(tMatricule);
		panInfirmier1.add(lNom);
		panInfirmier1.add(tNom);
		panInfirmier1.add(bAdd);
		panInfirmier1.add(bAnnuler);
		panInfirmier1.add(bDispose);
		panInfirmier1.add(bAfficher);
		Font police = new Font("Tahoma", Font.BOLD, 24);
		lMatricule.setFont(police);
		lMatricule.setForeground(Color.BLUE);
		lNom.setFont(police);
		lNom.setForeground(Color.BLUE);
		bAdd.setFont(police);
		bAdd.setForeground(Color.BLUE);
		bAnnuler.setFont(police);
		bAnnuler.setForeground(Color.RED);
		bDispose.setFont(police);
		bDispose.setForeground(Color.RED);
		bAfficher.setFont(police);
		bAfficher.setForeground(Color.BLUE);
		
		bAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutInfirmier(tMatricule.getText(), tNom.getText());
				dispose();
				
			}

			private void AjoutInfirmier(String Matricule, String Nom) {
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
					String requete = "INSERT INTO infirmier(`Matricule`,`Nom`)values(?, ? )";
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
		bAnnuler.setFont(police);
		bAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tMatricule.setText("");
				tNom.setText("");
				
			}
			
		});
		bAnnuler.setForeground(Color.RED);
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img17.PNG"));
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img18.PNG"));
		
		
		
		
		panelPrincipale.setLayout(new BorderLayout());
		panelPrincipale.add(panInfirmier1, BorderLayout.NORTH);
		panelPrincipale.add(lIcon1, BorderLayout.EAST);
		panelPrincipale.add(lIcon2, BorderLayout.WEST);
		
		
		
		
		
		
		
		/*lMatricule = new JLabel("Matricule");
		lMatricule.setBounds(5, 3, 125, 25);
		lNom = new JLabel("Nom");
		lNom.setBounds(5, 35, 125, 25);
		tMatricule = new JTextField(10);
		tMatricule.setBounds(130, 3, 125, 25);
		tNom = new JTextField(10);
		tNom.setBounds(130, 35, 125, 25);
		bAdd = new JButton("ADD");
		bAdd.setBounds(5, 75, 125, 25);
		bAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AjoutInfirmier(tMatricule.getText(), tNom.getText());
				dispose();
				
			}

			private void AjoutInfirmier(String Nom, String Matricule) {
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
					String requete = "INSERT INTO infirmier(`Matricule`,`Nom`)values(?, ? )";
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
		bAnnuler = new JButton("Suprimer");
		bAnnuler.setBounds(150, 75, 125, 25);
		
		panelPrincipale.setLayout(null);
		panelPrincipale.add(lMatricule);
		panelPrincipale.add(tMatricule);
		panelPrincipale.add(lNom);
		panelPrincipale.add(tNom);
		panelPrincipale.add(bAdd);
		panelPrincipale.add(bAnnuler);
		
		*/
	}
	
	

}
