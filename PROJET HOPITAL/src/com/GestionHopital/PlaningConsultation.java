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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class PlaningConsultation extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JLabel lMatricule, lIcon1, lIcon2, lJour, lHeureD, lHeureF;
	private JComboBox cMatricule;
	private JButton bOk, bAnnuler,bDispose, bAfficher;
	private JPanel panIcon, panConsult1, panConsult2, panConsult3, panConsult4;
	private JTextField tJour, tHeureD, tHeureF;
	
	//private Data date;
	
	
	public PlaningConsultation(){
		this.setTitle("PLANING CONSULTATION");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initcomportment();
		this.setContentPane(panelPrincipale);
		this.setVisible(true);
	}
		
		public String[] lireMatricule(){
			String[] str = null;
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				//Affichage de sa reussite
				System.out.println(" Diver Ok ");
				String bdd = "Votre base des données";
				String url = "jdbc:mysql://localhost/hopital";
				String user = "root";
				String passwd = "";
				// Creation de la connection
				Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
				System.out.println("Connection Effective");
				
				//Creer un etat de connection( c'est statement qui fait les operations dans la bd)
				// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
				java.sql.Statement state = conn.createStatement();
				ResultSet result = state.executeQuery("SELECT Matricule FROM medecin");
				// Compte le nombre de ligne de result en se positionant sur le dernier elt 
				result.last();
				//initialiser le tableau avec pour taille le nombre de ligne de result
				str = new String[result.getRow()];
				result.beforeFirst();
				int i = 0;
				while(result.next()){
					str[i] =  result.getString("Matricule"); i++;
				}
				//System.out.println(result.getRow());
				for(i = 0; i< str.length; i++)
					System.out.println(str[i]);
				
				result.close();
				state.close();
				
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("erreur detecter");
			}
			return str;
			
		}
		
	public void confirmConsultation(String cMatricule, String tJours, String tHeureD, String tHeureF){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				//Affichage de sa reussite
				System.out.println(" Diver Ok ");
				String bdd = "Votre base des données";
				String url = "jdbc:mysql://localhost/hopital";
				String user = "root";
				String passwd = "";
				// Creation de la connection
				Connection conn = (Connection)DriverManager.getConnection(url,user,passwd);
				System.out.println("Connection Effective");
				// on peu aussi ecrire  Statement state = (Statement)conn.createStatement();
				java.sql.Statement state = conn.createStatement();
				
				String requete = "INSERT INTO planingmedecin(`Matricule`, `Jours`, `HeureDebut`, `HeureFin`)values(?, ?, ?, ?)";
				PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
				prepare.setString(1, cMatricule);
				prepare.setString(2, tJours);
				prepare.setString(3, tHeureD);
				prepare.setString(4, tHeureF);
				System.out.println(prepare);
				prepare.executeUpdate();
				prepare.close();
				state.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("erreur detecter");
			}

			
		}
		

	private void initcomportment() {
		// TODO Auto-generated method stub
		
		//Gestion de l'image

		panIcon = new JPanel();
		panIcon.setLayout(new BorderLayout());
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img22.PNG"));
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img24.PNG"));
		panIcon.add(lIcon1, BorderLayout.WEST);
		panIcon.add(lIcon2, BorderLayout.CENTER);
				
		panConsult1 = new JPanel();
		GridLayout disposition  = new GridLayout(6, 2, 5, 5);
		panConsult1.setLayout(disposition);
		lMatricule = new JLabel("MATRICULE MEDECIN");
		JComboBox cMatricule = new JComboBox(lireMatricule());
		
		lJour = new JLabel("JOUR DE TRAVAIL");
		tJour = new JTextField(10);
		
		lHeureD =new JLabel("HEURE DE DEBUT");
		tHeureD = new JTextField(10);
		
		lHeureF =new JLabel("HEURE DE FIN");
		tHeureF = new JTextField(10);
		
		DateFormat forma = new SimpleDateFormat("hh:mm:ss");
		Calendar calenda = Calendar.getInstance();
		System.out.println(forma.format(calenda.getTime()));
		tHeureD.setText(forma.format(calenda.getTime()));
		tHeureF.setText(forma.format(calenda.getTime()));
		
		JButton bOk = new JButton("OK");
		 bAfficher = new JButton("DISPLAY");
		 bAfficher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AfficheFichePlaning plan = new AfficheFichePlaning();
				plan.setVisible(true);
				
			}
			 
		 });
		 bDispose = new JButton("CANCEL");
		 bDispose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			 
		 });
		bOk.addActionListener(new ActionListener(){

				@Override
		 public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			confirmConsultation((String) cMatricule.getSelectedItem(),(String)tJour.getText(),(String)tHeureD.getText(), (String)tHeureF.getText());
						
		}
				
	});
				
	JButton bAnnuler = new JButton("RESET");
	 bAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
				tJour.setText("");
				cMatricule.setSelectedItem("");
				
				
				
					}
					 
				 });
	 
	Font police = new Font("Tahoma", Font.BOLD, 18);
	lMatricule.setFont(police);
	lMatricule.setForeground(Color.BLUE);
	lJour.setFont(police);
	lJour.setForeground(Color.BLUE);
	lHeureD.setFont(police);
	lHeureD.setForeground(Color.BLUE);
	lHeureF.setFont(police);
	lHeureF.setForeground(Color.BLUE);
	bOk.setFont(police);
	bOk.setForeground(Color.BLUE);
	bAfficher.setFont(police);
	bAfficher.setForeground(Color.BLUE);
	bDispose.setFont(police);
	bDispose.setForeground(Color.RED);
	bAnnuler.setFont(police);
	bAnnuler.setForeground(Color.RED);
	 
	panConsult1.add(lMatricule);
	panConsult1.add(cMatricule);
	panConsult1.add(lJour);
	panConsult1.add(tJour);
	panConsult1.add(lHeureD);
	panConsult1.add(tHeureD);
	panConsult1.add(lHeureF);
	panConsult1.add(tHeureF);
	panConsult1.add(bOk);
	panConsult1.add(bAnnuler);
	panConsult1.add(bDispose);
	panConsult1.add(bAfficher);
	panelPrincipale.setLayout(new BorderLayout());
	panelPrincipale.add(panIcon, BorderLayout.SOUTH);
	panelPrincipale.add(panConsult1, BorderLayout.NORTH);
				
				
				
			}	
		
	}
	
	

