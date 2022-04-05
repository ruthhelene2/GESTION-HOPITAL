package com.GestionHopital;


import java.awt.BorderLayout;
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
import com.mysql.jdbc.Statement;

public class EnregistrerPatient extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JLabel lNom, lSexe, lIcon1, bBienvenu1;
	private JTextField tNom, tSexe;
	private JButton bAjouter, bSupprimer, bDispose, bAfficher;
	
	public EnregistrerPatient(){
		this.setTitle("SAVE PATIENT");
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
		lSexe = new JLabel(" SEXE");
		tNom = new JTextField(10);
		tSexe = new JTextField(10);
		bAjouter = new JButton(" ADD ");
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
				FichePatient fi = new FichePatient();
				
			}
			
		});
		bAjouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EnregistrerPatient(tNom.getText(), tSexe.getText());
				
			}

			private void EnregistrerPatient(String Nom, String Sexe) {
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
					String requete = "INSERT INTO patient(`Nom_P`, `Sexe`)values(?, ? )";
					PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
					prepare.setString(1, Nom);
					prepare.setString(2, Sexe);
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
				tNom.setText("");
				tSexe.setText("");
				
			}
			
		});
		Font pol = new Font("Tahoma", Font.BOLD, 24);
		lNom.setFont(pol);
		lNom.setForeground(Color.BLUE);
		lSexe.setFont(pol);
		lSexe.setForeground(Color.BLUE);
		bAjouter.setFont(pol);
		bAjouter.setForeground(Color.BLUE);
		bSupprimer.setFont(pol);
		bSupprimer.setForeground(Color.RED);
		bDispose.setFont(pol);
		bDispose.setForeground(Color.RED);
		bAfficher.setFont(pol);
		bAfficher.setForeground(Color.BLUE);
		
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img12.PNG"));
		bBienvenu1 = new JLabel("AJOUTEZ UN PATIENT");
		Font police = new Font("Tahoma", Font.BOLD, 24);
		bBienvenu1.setFont(police);
		bBienvenu1.setForeground(Color.MAGENTA);
		
		
		panelPrincipale.add(lNom);
		panelPrincipale.add(tNom);
		panelPrincipale.add(lSexe);
		panelPrincipale.add(tSexe);
		panelPrincipale.add(bAjouter);
		panelPrincipale.add(bSupprimer);
		panelPrincipale.add(bDispose);
		panelPrincipale.add(bAfficher);
		panelPrincipale.add(lIcon1);
		panelPrincipale.add(bBienvenu1);
		
	}
		
		

}

