package com.GestionHopital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import com.mysql.jdbc.Statement;

public class AfficherConsultation extends JFrame{
	private JPanel panelPrincipale = new JPanel();
	private JLabel lPatient, lMatricule, lIcon1, lIcon2, ldate;
	private JComboBox cPatient, cMatricule;
	private JButton bOk, bAnnuler, bDispose;
	private JPanel panIcon, panConsult1, panConsult2, panConsult3, panConsult4;
	private JTextField tdate;
	
	//private Data date;
	
	
	public AfficherConsultation(){
		this.setTitle("CONSULTATION PATIENT");
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
	public String[] lirePatient(){
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
			Statement state = (Statement) conn.createStatement();
			ResultSet result = state.executeQuery("SELECT Num_P FROM patient");
			// Compter le nombre de ligne du result en se positionant sur le dernier elt 
			result.last();
			//initialiser le tableau avec pour taille le nombre de ligne de result
			str = new String[result.getRow()];
			result.beforeFirst();
			int i = 0;
			while(result.next()){
				str[i] =  result.getString("Num_P"); i++;
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
	
	public void confirmConsultation(String date, String Matricule, String NumeroPatient){
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
			
			String requete = "INSERT INTO consultation(`Date`,`Matricule`, `Num_P`)values(?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
			prepare.setString(1, date);
			prepare.setString(2, Matricule);
			prepare.setString(3, NumeroPatient);
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
		
		//Gestion de l'image

		panIcon = new JPanel();
		panIcon.setLayout(new BorderLayout());
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img20.PNG"));
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img21.PNG"));
		panIcon.add(lIcon1, BorderLayout.WEST);
		panIcon.add(lIcon2, BorderLayout.CENTER);
		
		panConsult1 = new JPanel();
		GridLayout disposition  = new GridLayout(2, 3, 5, 5);
		panConsult1.setLayout(disposition);
		lMatricule = new JLabel("MATRICULE MEDECIN");
		JComboBox cMatricule = new JComboBox(lireMatricule());
		
		lPatient = new JLabel("NUMERO PATIENT");
		JComboBox cPatient = new JComboBox(lirePatient());
		
		ldate = new JLabel("ENTRER UNE DATE");
		tdate = new JTextField(10);
		
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		System.out.println(format.format(calendar.getTime()));
		tdate.setText(format.format(calendar.getTime()));
		
		JButton bOk = new JButton("VALIDER");
		//bDispose = new JButton("CANCEL");
		
		bOk.addActionListener(new ActionListener(){

			@Override
 			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				confirmConsultation((String)tdate.getText(),(String) cMatricule.getSelectedItem(),(String)cPatient.getSelectedItem());
				
			}
		
		});
		
		JButton bAnnuler = new JButton("AFFICHER");
		 bAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//AfficherFicheConsultation aff = new AfficherFicheConsultation();
				//aff.setVisible(true);
				AfficherFicheConsultation af = new AfficherFicheConsultation();
				af.setVisible(true);
			}
			 
		 });
		Font police = new Font("Tahoma", Font.BOLD, 12);
		lMatricule.setFont(police);
		lMatricule.setForeground(Color.BLUE);
		lPatient.setFont(police);
		lPatient.setForeground(Color.BLUE);
		ldate.setFont(police);
		ldate.setForeground(Color.BLUE);
		bOk.setFont(police);
		bOk.setForeground(Color.BLUE);
		bAnnuler.setFont(police);
		bAnnuler.setForeground(Color.BLUE);
		 
		 panConsult1.add(lMatricule);
		 panConsult1.add(cMatricule);
		 panConsult1.add(lPatient);
		 panConsult1.add(cPatient);
		 panConsult1.add(ldate);
		 panConsult1.add(tdate);
		 panConsult1.add(bOk);
		 panConsult1.add(bAnnuler);
		 //panConsult1.add(bDispose);
		 
		 
		panelPrincipale.setLayout(new BorderLayout());
		panelPrincipale.add(panIcon, BorderLayout.SOUTH);
		panelPrincipale.add(panConsult1, BorderLayout.NORTH);
		
		
		
	}
	

}
