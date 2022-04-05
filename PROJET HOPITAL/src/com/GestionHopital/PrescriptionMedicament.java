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
import com.mysql.jdbc.Statement;

public class PrescriptionMedicament extends JFrame {
	private JPanel panelPrincipale = new JPanel();
	private JLabel lMatricule, lPatient, lLibele, lCode, lNbrePrise, lPharmacie, lIcon1, lIcon2;
	private JComboBox cMatricule, cpatient;
	private JTextField tLibele, tCode, tNbrePrise,tPharmacie;
	private JPanel panIcon, panConsult1;
	private JButton bValider, bAnnuler, bDispose, bAfficher;
	
	
	
	public PrescriptionMedicament(){
		this.setTitle("PRESCRIPTION DU MEDECIN");
		this.setSize(700, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelPrincipale);
		initComportment();
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
	public void confirmConsultation(String tCode, String cMatricule, String cPatient, String tLibele, String tPharmecie, String tNbrePrise){
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
			
			String requete = "INSERT INTO prescrire(`Code_M`,`Matricule`, `Num_P`, `Libélé`, `Pharmacie`,`NbrePrise`)values(?, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = (PreparedStatement) conn.prepareStatement(requete);
			prepare.setString(1, tCode);
			prepare.setString(2, cMatricule);
			prepare.setString(3, cPatient);
			prepare.setString(4, tLibele);
			prepare.setString(5, tPharmecie);
			prepare.setString(6, tNbrePrise);
			System.out.println(prepare);
			prepare.executeUpdate();
			prepare.close();
			state.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur detecter");
		}

	}

	private void initComportment() {
		// TODO Auto-generated method stub
		panIcon = new JPanel();
		panIcon.setLayout(new BorderLayout());
		lIcon1 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img25.PNG"));
		lIcon2 = new JLabel(new ImageIcon("C:/Users/RUTH/Pictures/Saved Pictures/img27.PNG"));
		panIcon.add(lIcon1, BorderLayout.WEST);
		panIcon.add(lIcon2, BorderLayout.CENTER);
		
		panConsult1 = new JPanel();
		GridLayout disposition  = new GridLayout(8, 2, 5, 5);
		panConsult1.setLayout(disposition);
		lMatricule = new JLabel("MATRICULE MEDECIN");
		JComboBox cMatricule = new JComboBox(lireMatricule());
		
		lPatient = new JLabel("NUMERO PATIENT");
		JComboBox cPatient = new JComboBox(lirePatient());
		
		lCode = new JLabel("Code Medicament");
		tCode = new JTextField(10);
		
		lPharmacie = new JLabel("Pharmacie");
		tPharmacie = new JTextField(10);
		
		lLibele = new JLabel("NOM MEDICAMENT");
		tLibele = new JTextField(10);
		
		lNbrePrise = new JLabel("Nombre De Prise");
		tNbrePrise = new JTextField(10);
		
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
				FichePrescription fichPresc = new FichePrescription();
				fichPresc.setVisible(true);
				
			}
			
		});
		
		
		JButton bValider = new JButton("VALIDER");
		bValider.addActionListener(new ActionListener(){

			@Override
 			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				confirmConsultation((String)tCode.getText(),(String) cMatricule.getSelectedItem(),(String)cPatient.getSelectedItem(), (String)tLibele.getText(), (String)tPharmacie.getText(), tNbrePrise.getText());
				
			}
		
		});
		
		JButton bAnnuler = new JButton("RESET");
		 bAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tCode.setText("");
				tLibele.setText("");
				tPharmacie.setText("");
				tNbrePrise.setText("");
	
				
			}
			 
		 });
		Font police = new Font("Tahoma", Font.BOLD, 12);
		lMatricule.setFont(police);
		lMatricule.setForeground(Color.BLUE);
		lPatient.setFont(police);
		lPatient.setForeground(Color.BLUE);
		lCode.setFont(police);
		lCode.setForeground(Color.BLUE);
		lLibele.setFont(police);
		lLibele.setForeground(Color.BLUE);
		lPharmacie.setFont(police);
		lPharmacie.setForeground(Color.BLUE);
		lNbrePrise.setFont(police);
		lNbrePrise.setForeground(Color.BLUE);
		bValider.setFont(police);
		bValider.setForeground(Color.BLUE);
		bAnnuler.setFont(police);
		bAnnuler.setForeground(Color.RED);
		bDispose.setFont(police);
		bDispose.setForeground(Color.RED);
		bAfficher.setFont(police);
		bAfficher.setForeground(Color.BLUE);
		 
		 panConsult1.add(lMatricule);
		 panConsult1.add(cMatricule);
		 panConsult1.add(lPatient);
		 panConsult1.add(cPatient);
		 panConsult1.add(lCode);
		 panConsult1.add(tCode);
		 panConsult1.add(lLibele);
		 panConsult1.add(tLibele);
		 panConsult1.add(lPharmacie);
		 panConsult1.add(tPharmacie);
		 panConsult1.add(lNbrePrise);
		 panConsult1.add(tNbrePrise);
		 panConsult1.add(bValider);
		 panConsult1.add(bAnnuler);
		 panConsult1.add(bDispose);
		 panConsult1.add(bAfficher);
		 
		panelPrincipale.setLayout(new BorderLayout());
		panelPrincipale.add(panIcon, BorderLayout.SOUTH);
		panelPrincipale.add(panConsult1, BorderLayout.NORTH);
		
		
		
	}
	
	
	

}
